// Generated by view binder compiler. Do not edit!
package com.example.eathappy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.eathappy.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MarcaItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView cifMarca;

  @NonNull
  public final TextView direccionMarca;

  @NonNull
  public final TextView nombreMarca;

  @NonNull
  public final TextView telefonoMarca;

  private MarcaItemBinding(@NonNull LinearLayout rootView, @NonNull TextView cifMarca,
      @NonNull TextView direccionMarca, @NonNull TextView nombreMarca,
      @NonNull TextView telefonoMarca) {
    this.rootView = rootView;
    this.cifMarca = cifMarca;
    this.direccionMarca = direccionMarca;
    this.nombreMarca = nombreMarca;
    this.telefonoMarca = telefonoMarca;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MarcaItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MarcaItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.marca_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MarcaItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cifMarca;
      TextView cifMarca = ViewBindings.findChildViewById(rootView, id);
      if (cifMarca == null) {
        break missingId;
      }

      id = R.id.direccionMarca;
      TextView direccionMarca = ViewBindings.findChildViewById(rootView, id);
      if (direccionMarca == null) {
        break missingId;
      }

      id = R.id.nombreMarca;
      TextView nombreMarca = ViewBindings.findChildViewById(rootView, id);
      if (nombreMarca == null) {
        break missingId;
      }

      id = R.id.telefonoMarca;
      TextView telefonoMarca = ViewBindings.findChildViewById(rootView, id);
      if (telefonoMarca == null) {
        break missingId;
      }

      return new MarcaItemBinding((LinearLayout) rootView, cifMarca, direccionMarca, nombreMarca,
          telefonoMarca);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
