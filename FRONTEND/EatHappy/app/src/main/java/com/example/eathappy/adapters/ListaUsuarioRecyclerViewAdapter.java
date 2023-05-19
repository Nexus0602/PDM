package com.example.eathappy.adapters;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eathappy.ConsultarUsuario;
import com.example.eathappy.EliminarUsuario;
import com.example.eathappy.ModificarUsuario;
import com.example.eathappy.R;
import com.example.eathappy.dao.Usuario;
import com.example.eathappy.servicios.EatHappyApiInterface;

import java.util.List;

public class ListaUsuarioRecyclerViewAdapter extends RecyclerView.Adapter<ListaUsuarioRecyclerViewAdapter.UsuarioViewHolder> {

    private EatHappyApiInterface apiInterface;
    private List<Usuario> listaUsuarios;

    private Activity consultar;

    private ConsultarUsuario consultarActivity = new ConsultarUsuario();
    public ListaUsuarioRecyclerViewAdapter(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;

    }
    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.usuario_item, parent, false);
        Log.i("onCreateViewHolder", "Cargada la vista alumnoView");
        return  new UsuarioViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaUsuarioRecyclerViewAdapter.UsuarioViewHolder holder, int position) {
        Usuario currentUsuario = listaUsuarios.get(position);
        holder.bind(currentUsuario);
        Log.i("onBindViewer","Cargado usuario " + position + ", de id " + currentUsuario.getId());

    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }


    public class UsuarioViewHolder  extends RecyclerView.ViewHolder {

        private TextView idUsuarioTextView;
        private TextView nombreUsuarioTextView;
        private TextView apellidosUsuarioTextView;
        private TextView emailUsuarioTextView;
        private TextView contrasenyaUsuarioTextView;
        private TextView alergenosUsuarioTextView;
        private TextView favoritosUsuarioTextView;
        private ListaUsuarioRecyclerViewAdapter usuarioAdapter;



        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            idUsuarioTextView = itemView.findViewById(R.id.idUsuario);
            nombreUsuarioTextView = itemView.findViewById(R.id.nombreUsuario);
            //apellidosUsuarioTextView = itemView.findViewById(R.id.apellidosUsuario);
            //emailUsuarioTextView = itemView.findViewById(R.id.emailUsuario);
            //contrasenyaUsuarioTextView = itemView.findViewById(R.id.contrasenyaUsuario);
            //alergenosUsuarioTextView = itemView.findViewById(R.id.alergenosUsuario);
            //favoritosUsuarioTextView = itemView.findViewById(R.id.favoritosUsuario);

        }

        public void bind(Usuario currentUsuario) {

            idUsuarioTextView.setText(currentUsuario.getId().toString());
            nombreUsuarioTextView.setText(currentUsuario.getNombre());
            //apellidosUsuarioTextView.setText(currentUsuario.getApellidos());
            //emailUsuarioTextView.setText(currentUsuario.getEmail());
            //contrasenyaUsuarioTextView.setText(currentUsuario.getContrasenya());
            /*if (currentUsuario.getAlergenos()!=null)
                alergenosUsuarioTextView.setText(currentUsuario.getAlergenos().toString());
            else
                alergenosUsuarioTextView.setText("");*/
            //favoritosUsuarioTextView.setText(currentUsuario.getFavoritos().toString());

            nombreUsuarioTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mostrarMenuDesplegable(currentUsuario);
                }
            });
            }



        private void mostrarMenuDesplegable(Usuario currentUsuario) {
            //usuarioAdapter = new ListaUsuarioRecyclerViewAdapter(listaUsuarios,apiInterface);
            AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
            builder.setTitle("Opciones de usuario")
                    .setItems(new CharSequence[]{"Consultar", "Modificar", "Eliminar"}, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            switch (which) {
                                case 0: // Consultar
                                    // Dentro de una actividad existente
                                    Intent intent = new Intent(itemView.getContext(), ConsultarUsuario.class);
                                    intent.putExtra("usuario",currentUsuario.getId().toString());
                                    itemView.getContext().startActivity(intent);
                                    //consultarActivity.consultarUsuario(currentUsuario);
                                    break;
                                case 1: // Modificar
                                    Intent intent2 = new Intent(itemView.getContext(), ModificarUsuario.class);
                                    intent2.putExtra("id",currentUsuario.getId().toString());
                                    itemView.getContext().startActivity(intent2);
                                    //modificarUsuario(currentUsuario);
                                    break;
                                case 2: // Eliminar
                                    Intent intent3 = new Intent(itemView.getContext(), EliminarUsuario.class);
                                    intent3.putExtra("id",currentUsuario.getId().toString());
                                    itemView.getContext().startActivity(intent3);
                                    //eliminarUsuario(currentUsuario);
                                    break;
                            }
                        }
                    });
            builder.create().show();
        }



        private void modificarUsuario(Usuario usuario) {
            // Acción de modificación del usuario
        }

        private void eliminarUsuario(Usuario usuario) {
            // Acción de eliminación del usuario
        }


    }
        

}


