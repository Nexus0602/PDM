package com.example.eathappy.adapters;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eathappy.ListadoCategorias;
import com.example.eathappy.ListadoProductosPorCategoria;
import com.example.eathappy.R;
import com.example.eathappy.RegistarUsuarioActivity;
import com.example.eathappy.dao.Categoria;
import com.example.eathappy.servicios.EatHappyApiInterface;

import java.util.List;

public class ListaCategoriasReciclerViewAdapter extends  RecyclerView.Adapter<ListaCategoriasReciclerViewAdapter.CategoriaViewHolder>  {

    private List<Categoria> listaCategorias;
    private ListaCategoriasReciclerViewAdapter listaCategoriasReciclerViewAdapter;

    public ListaCategoriasReciclerViewAdapter(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_item, parent, false);
        Log.i("onCreateViewHolder", "Cargada la vista alumnoView");
        return  new CategoriaViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ListaCategoriasReciclerViewAdapter.CategoriaViewHolder holder, int position) {
        Categoria currentCategoria = listaCategorias.get(position);
        holder.bind(currentCategoria);
        Log.i("onBindViewer","Cargada catgoria " + position + ", de nombre " + currentCategoria.getNombre());
    }



    @Override
    public int getItemCount() {
        return listaCategorias.size();
    }

    public class CategoriaViewHolder  extends RecyclerView.ViewHolder {

        private TextView nombreCategoriaTextView;

        public CategoriaViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreCategoriaTextView = itemView.findViewById(R.id.nombreCategoria);
        }

        public void bind(Categoria currentCategoria) {

            nombreCategoriaTextView.setText(currentCategoria.getNombre());

            nombreCategoriaTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(itemView.getContext(), ListadoProductosPorCategoria.class);
                    intent.putExtra("nombre",currentCategoria.getNombre().toString());
                    itemView.getContext().startActivity(intent);
                }

            });
        }
    }}
