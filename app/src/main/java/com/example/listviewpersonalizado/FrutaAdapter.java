package com.example.listviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

class FrutaAdapter extends ArrayAdapter {
    Context mContext;
    int mRecurso;

    public FrutaAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.mRecurso = resource;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mRecurso,parent, false);

        //Associar objetos as variaveis locais
        TextView tvCodigo = convertView.findViewById(R.id.tvCodigo);
        TextView tvNome = convertView.findViewById(R.id.tvNome);
        TextView tvPreco = convertView.findViewById(R.id.tvPreco);
        TextView tvPrecoVenda = convertView.findViewById(R.id.tvPrecoVenda);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        Fruta fruta = (Fruta) getItem(position);

        DecimalFormat nf = new DecimalFormat("#,###,00");
        //Populando o layout
        tvCodigo.setText(Integer.toString(fruta.getCodigo()));
        tvNome.setText(fruta.getNome());
        tvPreco.setText(nf.format(fruta.getPreco()));
        tvPrecoVenda.setText(nf.format(fruta.getPreco_venda()));
        imageView.setImageResource(fruta.getImagem());

        return convertView;
    }
}
