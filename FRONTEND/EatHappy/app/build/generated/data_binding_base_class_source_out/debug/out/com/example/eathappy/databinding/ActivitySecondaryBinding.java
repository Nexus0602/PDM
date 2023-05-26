// Generated by view binder compiler. Do not edit!
package com.example.eathappy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.eathappy.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySecondaryBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button botonProductos;

  @NonNull
  public final Button botonUsuarios;

  private ActivitySecondaryBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button botonProductos, @NonNull Button botonUsuarios) {
    this.rootView = rootView;
    this.botonProductos = botonProductos;
    this.botonUsuarios = botonUsuarios;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySecondaryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySecondaryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_secondary, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySecondaryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.botonProductos;
      Button botonProductos = ViewBindings.findChildViewById(rootView, id);
      if (botonProductos == null) {
        break missingId;
      }

      id = R.id.botonUsuarios;
      Button botonUsuarios = ViewBindings.findChildViewById(rootView, id);
      if (botonUsuarios == null) {
        break missingId;
      }

      return new ActivitySecondaryBinding((ConstraintLayout) rootView, botonProductos,
          botonUsuarios);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}