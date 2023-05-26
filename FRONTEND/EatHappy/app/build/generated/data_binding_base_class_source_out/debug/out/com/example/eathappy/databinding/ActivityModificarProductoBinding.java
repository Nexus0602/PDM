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

public final class ActivityModificarProductoBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonModificar;

  @NonNull
  public final EditText categoriaProducto;

  @NonNull
  public final EditText codBarrasProducto;

  @NonNull
  public final EditText composicionProducto;

  @NonNull
  public final EditText marcaProducto;

  @NonNull
  public final EditText nombreProducto;

  @NonNull
  public final TextView succes;

  private ActivityModificarProductoBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button buttonModificar, @NonNull EditText categoriaProducto,
      @NonNull EditText codBarrasProducto, @NonNull EditText composicionProducto,
      @NonNull EditText marcaProducto, @NonNull EditText nombreProducto, @NonNull TextView succes) {
    this.rootView = rootView;
    this.buttonModificar = buttonModificar;
    this.categoriaProducto = categoriaProducto;
    this.codBarrasProducto = codBarrasProducto;
    this.composicionProducto = composicionProducto;
    this.marcaProducto = marcaProducto;
    this.nombreProducto = nombreProducto;
    this.succes = succes;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityModificarProductoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityModificarProductoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_modificar_producto, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityModificarProductoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonModificar;
      Button buttonModificar = ViewBindings.findChildViewById(rootView, id);
      if (buttonModificar == null) {
        break missingId;
      }

      id = R.id.categoriaProducto;
      EditText categoriaProducto = ViewBindings.findChildViewById(rootView, id);
      if (categoriaProducto == null) {
        break missingId;
      }

      id = R.id.codBarrasProducto;
      EditText codBarrasProducto = ViewBindings.findChildViewById(rootView, id);
      if (codBarrasProducto == null) {
        break missingId;
      }

      id = R.id.composicionProducto;
      EditText composicionProducto = ViewBindings.findChildViewById(rootView, id);
      if (composicionProducto == null) {
        break missingId;
      }

      id = R.id.marcaProducto;
      EditText marcaProducto = ViewBindings.findChildViewById(rootView, id);
      if (marcaProducto == null) {
        break missingId;
      }

      id = R.id.nombreProducto;
      EditText nombreProducto = ViewBindings.findChildViewById(rootView, id);
      if (nombreProducto == null) {
        break missingId;
      }

      id = R.id.succes;
      TextView succes = ViewBindings.findChildViewById(rootView, id);
      if (succes == null) {
        break missingId;
      }

      return new ActivityModificarProductoBinding((ConstraintLayout) rootView, buttonModificar,
          categoriaProducto, codBarrasProducto, composicionProducto, marcaProducto, nombreProducto,
          succes);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
