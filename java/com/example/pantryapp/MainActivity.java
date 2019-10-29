package com.example.pantryapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,PedidosFragment.OnFragmentInteractionListener {

    public TextView usuarioLogado;
    private AppBarConfiguration mAppBarConfiguration;
    public String UsuarioRecebido;
    public ImageView imagemUsuario;
    public TextView nomeProduto;
    public TextView descProduto;
    public TextView valorProduto;
    public ImageView fotoProduto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.nomeProduto = findViewById(R.id.nomeProduto);



    Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_inicio,R.id.nav_pedidos)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Obtém a referência da view de cabeçalho
        View headerView = navigationView.getHeaderView(0);
        usuarioLogado = (TextView) headerView.findViewById(R.id.usuarioLogado);
        imagemUsuario = (ImageView) headerView.findViewById(R.id.imagemUsuario);

        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        if(bundle != null) {
            UsuarioRecebido = bundle.getString("usuarioRecebido");
        }
        usuarioLogado.setText(UsuarioRecebido);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void Abrircarrinho(View view) {
        Intent it = new Intent(this, CarrinhoActivity.class);
        startActivity(it);
    }

    public void alterarFoto(View view){
//        int CAMERA_PICTURE = 0;
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(intent, CAMERA_PICTURE);
//        this.imagemUsuario.setImageResource(CAMERA_PICTURE);

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"), 1);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void Abrirproduto (View view){
        Intent it = new Intent (this,ProdutoActivity.class);
        startActivity(it);

    }


}
