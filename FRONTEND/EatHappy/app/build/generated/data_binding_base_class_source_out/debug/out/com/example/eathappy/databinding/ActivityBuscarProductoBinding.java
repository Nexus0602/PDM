// Generated by view binder compiler. Do not edit!
package com.example.eathappy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.eathappy.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityBuscarProductoBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView alergenosProducto;

  @NonNull
  public final Button buttonRegistrar;

  @NonNull
  public final TextView categoriaProducto;

  @NonNull
  public final TextView codBarrasProducto;

  @NonNull
  public final TextView composicionProducto;

  @NonNull
  public final EditText editTextCodigo;

  @NonNull
  public final TextView error;

  @NonNull
  public final TextView idProducto;

  @NonNull
  public final TextView marcaProducto;

  @NonNull
  public final TextView nombreProducto;

  @NonNull
  public final TextView opinionesProducto;

  @NonNull
  public final TextView succes;

  private ActivityBuscarProductoBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView alergenosProducto, @NonNull Button buttonRegistrar,
      @NonNull TextView categoriaProducto, @NonNull TextView codBarrasProducto,
      @NonNull TextView composicionProducto, @NonNull EditText editTextCodigo,
      @NonNull TextView error, @NonNull TextView idProducto, @NonNull TextView marcaProducto,
      @NonNull TextView nombreProducto, @NonNull TextView opinionesProducto,
      @NonNull TextView succes) {
    this.rootView = rootView;
    this.alergenosProducto = alergenosProducto;
    this.buttonRegistrar = buttonRegistrar;
    this.categoriaProducto = categoriaProducto;
    this.codBarrasProducto = codBarrasProducto;
    this.composicionProducto = composicionProducto;
    this.editTextCodigo = editTextCodigo;
    this.error = error;
    this.idProducto = idProducto;
    this.marcaProducto = marcaProducto;
    this.nombreProducto = nombreProducto;
    this.opinionesProducto = opinionesProducto;
    this.succes = succes;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityBuscarProductoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityBuscarProductoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_buscar_producto, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityBuscarProductoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.alergenosProducto;
      TextView alergenosProducto = ViewBindings.findChildViewById(rootView, id);
      if (alergenosProducto == null) {
        break missingId;
      }

      id = R.id.buttonRegistrar;
      Button buttonRegistrar = ViewBindings.findChildViewById(rootView, id);
      if (buttonRegistrar == null) {
        break missingId;
      }

      id = R.id.categoriaProducto;
      TextView categoriaProducto = ViewBindings.findChildViewById(rootView, id);
      if (categoriaProducto == null) {
        break missingId;
      }

      id = R.id.codBarrasProducto;
      TextView codBarrasProducto = ViewBindings.findChildViewById(rootView, id);
      if (codBarrasProducto == null) {
        break missingId;
      }

      id = R.id.composicionProducto;
      TextView composicionProducto = ViewBindings.findChildViewById(rootView, id);
      if (composicionProducto == null) {
        break missingId;
      }

      id = R.id.editTextCodigo;
      EditText editTextCodigo = ViewBindings.findChildViewById(rootView, id);
      if (editTextCodigo == null) {
        break missingId;
      }

      id = R.id.error;
      TextView error = ViewBindings.findChildViewById(rootView, id);
      if (error == null) {
        break missingId;
      }

      id = R.id.idProducto;
      TextView idProducto = ViewBindings.findChildViewById(rootView, id);
      if (idProducto == null) {
        break missingId;
      }

      id = R.id.marcaProducto;
      TextView marcaProducto = ViewBindings.findChildViewById(rootView, id);
      if (marcaProducto == null) {
        break missingId;
      }

      id = R.id.nombreProducto;
      TextView nombreProducto = ViewBindings.findChildViewById(rootView, id);
      if (nombreProducto == null) {
        break missingId;
      }

      id = R.id.opinionesProducto;
      TextView opinionesProducto = ViewBindings.findChildViewById(rootView, id);
      if (opinionesProducto == null) {
        break missingId;
      }

      id = R.id.succes;
      TextView succes = ViewBindings.findChildViewById(rootView, id);
      if (succes == null) {
        break missingId;
      }

      return new ActivityBuscarProductoBinding((ConstraintLayout) rootView, alergenosProducto,
          buttonRegistrar, categoriaProducto, codBarrasProducto, composicionProducto,
          editTextCodigo, error, idProducto, marcaProducto, nombreProducto, opinionesProducto,
          succes);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}