package com.example.eathappy.adapters;

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

import com.example.eathappy.ConsultarProducto;
import com.example.eathappy.ConsultarUsuario;
import com.example.eathappy.EliminarProducto;
import com.example.eathappy.EliminarUsuario;
import com.example.eathappy.MainActivity;
import com.example.eathappy.ModificarProducto;
import com.example.eathappy.ModificarUsuario;
import com.example.eathappy.R;
import com.example.eathappy.dao.Producto;

import java.util.List;

public class ListaProductoRecyclerViewAdapter extends RecyclerView.Adapter<ListaProductoRecyclerViewAdapter.ProductoViewHolder> {

    private List<Producto> listaProductos;

    public ListaProductoRecyclerViewAdapter(List<Producto> lista)
        {listaProductos = lista;}
    @NonNull
    @Override
    public ListaProductoRecyclerViewAdapter.ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.usuario_item, parent, false);
        Log.i("onCreateViewHolder", "Cargada la vista alumnoView");
        return  new ListaProductoRecyclerViewAdapter.ProductoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaProductoRecyclerViewAdapter.ProductoViewHolder holder, int position) {
        Producto currentProducto = listaProductos.get(position);
        holder.bind(currentProducto);
        Log.i("onBindViewer","Cargado producto " + position + ", de id " + currentProducto.getId());

    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {

        private TextView idProductoTextView;
        private TextView nombreProductoTextView;


        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            idProductoTextView = itemView.findViewById(R.id.idUsuario);
            nombreProductoTextView = itemView.findViewById(R.id.nombreUsuario);

        }

        public void bind(Producto currentProducto) {

            idProductoTextView.setText(currentProducto.getId().toString());
            nombreProductoTextView.setText(currentProducto.getNombre());

            nombreProductoTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mostrarMenuDesplegable(currentProducto);
                }
            });
        }

        private void mostrarMenuDesplegable(Producto currentProducto) {

            AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
            builder.setTitle("Opciones de usuario")
                    .setItems(new CharSequence[]{"Consultar", "Modificar", "Eliminar"}, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0: // Consultar
                                    Intent intent = new Intent(itemView.getContext(), ConsultarProducto.class);
                                    intent.putExtra("id",currentProducto.getId().toString());
                                    itemView.getContext().startActivity(intent);

                                    break;
                                case 1: // Modificar
                                    Intent intent2 = new Intent(itemView.getContext(), ModificarProducto.class);
                                    intent2.putExtra("id",currentProducto.getId().toString());
                                    itemView.getContext().startActivity(intent2);
                                    //modificarProducto(currentProducto);
                                    break;
                                case 2: // Eliminar+
                                    Intent intent3 = new Intent(itemView.getContext(), EliminarProducto.class);
                                    intent3.putExtra("id",currentProducto.getId().toString());
                                    itemView.getContext().startActivity(intent3);
                                    //eliminarProducto(currentProducto);
                                    break;
                            }
                        }
                    });
            builder.create().show();
        }

    }
}


