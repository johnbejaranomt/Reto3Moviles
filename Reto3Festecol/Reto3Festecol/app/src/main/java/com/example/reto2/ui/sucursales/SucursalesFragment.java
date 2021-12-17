package com.example.reto2.ui.sucursales;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.reto2.FormActivity;
import com.example.reto2.R;
import com.example.reto2.adaptadores.ProductoAdapter;
import com.example.reto2.adaptadores.SucursalAdapter;
import com.example.reto2.casos_uso.CasoUsoProducto;
import com.example.reto2.casos_uso.CasoUsoSucursales;
import com.example.reto2.databinding.FragmentSucursalesBinding;
import com.example.reto2.datos.DBHelper;
import com.example.reto2.modelos.Producto;
import com.example.reto2.modelos.Sucursal;

import java.util.ArrayList;


public class SucursalesFragment extends Fragment {
    private String TABLE_NAME = "SUCURSALES";
    private CasoUsoSucursales casoUsoSucursales;
    private GridView gridView;
    private DBHelper dbHelper;
    private ArrayList<Sucursal> sucursals;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sucursales, container,false);
        try{
            casoUsoSucursales = new CasoUsoSucursales();
            dbHelper = new DBHelper(getContext());
            Cursor cursor = dbHelper.getData(TABLE_NAME);
            sucursals = casoUsoSucursales.llenarListaSucursales(cursor);
            gridView = (GridView) root.findViewById(R.id.gridSucursales);
            SucursalAdapter sucursalAdapter = new SucursalAdapter(root.getContext(), sucursals);
            gridView.setAdapter(sucursalAdapter);
        }catch (Exception e){
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Intent intent = new Intent(getContext(), FormActivity.class);
                intent.putExtra("name","SUCURSALES");
                getActivity().startActivity(intent);
                //Toast.makeText(getContext(), "Hola Sucursal", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}