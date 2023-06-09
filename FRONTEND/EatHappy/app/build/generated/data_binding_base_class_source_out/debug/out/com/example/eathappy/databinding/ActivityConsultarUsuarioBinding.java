// Generated by view binder compiler. Do not edit!
package com.example.eathappy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class ActivityConsultarUsuarioBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView alergenosUsuario;

  @NonNull
  public final TextView apellidosUsuario;

  @NonNull
  public final TextView contrasenyaUsuario;

  @NonNull
  public final TextView emailUsuario;

  @NonNull
  public final TextView favoritosUsuario;

  @NonNull
  public final TextView idUsuario;

  @NonNull
  public final TextView nombreUsuario;

  private ActivityConsultarUsuarioBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView alergenosUsuario, @NonNull TextView apellidosUsuario,
      @NonNull TextView contrasenyaUsuario, @NonNull TextView emailUsuario,
      @NonNull TextView favoritosUsuario, @NonNull TextView idUsuario,
      @NonNull TextView nombreUsuario) {
    this.rootView = rootView;
    this.alergenosUsuario = alergenosUsuario;
    this.apellidosUsuario = apellidosUsuario;
    this.contrasenyaUsuario = contrasenyaUsuario;
    this.emailUsuario = emailUsuario;
    this.favoritosUsuario = favoritosUsuario;
    this.idUsuario = idUsuario;
    this.nombreUsuario = nombreUsuario;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityConsultarUsuarioBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityConsultarUsuarioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_consultar_usuario, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityConsultarUsuarioBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.alergenosUsuario;
      TextView alergenosUsuario = ViewBindings.findChildViewById(rootView, id);
      if (alergenosUsuario == null) {
        break missingId;
      }

      id = R.id.apellidosUsuario;
      TextView apellidosUsuario = ViewBindings.findChildViewById(rootView, id);
      if (apellidosUsuario == null) {
        break missingId;
      }

      id = R.id.contrasenyaUsuario;
      TextView contrasenyaUsuario = ViewBindings.findChildViewById(rootView, id);
      if (contrasenyaUsuario == null) {
        break missingId;
      }

      id = R.id.emailUsuario;
      TextView emailUsuario = ViewBindings.findChildViewById(rootView, id);
      if (emailUsuario == null) {
        break missingId;
      }

      id = R.id.favoritosUsuario;
      TextView favoritosUsuario = ViewBindings.findChildViewById(rootView, id);
      if (favoritosUsuario == null) {
        break missingId;
      }

      id = R.id.idUsuario;
      TextView idUsuario = ViewBindings.findChildViewById(rootView, id);
      if (idUsuario == null) {
        break missingId;
      }

      id = R.id.nombreUsuario;
      TextView nombreUsuario = ViewBindings.findChildViewById(rootView, id);
      if (nombreUsuario == null) {
        break missingId;
      }

      return new ActivityConsultarUsuarioBinding((ConstraintLayout) rootView, alergenosUsuario,
          apellidosUsuario, contrasenyaUsuario, emailUsuario, favoritosUsuario, idUsuario,
          nombreUsuario);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
