package com.example.a17170086.universidadeacme.fragments;


//public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener, HomeView{

    //ListView list_view_noticias;

    //NoticiaAdapter noticiaAdapter;


    //NoticiasService service;

    //HomePresenter presenter;

    //MainFragmentContract mainActivity;

    //public void configDependencias(MainFragmentContract mainActivity){
         //this.mainActivity = mainActivity;
    //}

    //TextView txt_teste;

    /*
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            txt_teste.setText("texto alterado");
        }
    };

*/

    //@Nullable
   // @Override
    //public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //carregando o XML para a vaiavel v
       // View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);

        //list_view_noticias = v.findViewById(R.id.list_view_noticias);


        //configurando o adapter
        //noticiaAdapter = new NoticiaAdapter(getContext());
        //list_view_noticias.setAdapter(noticiaAdapter);


        //configurando o click da lista
        //list_view_noticias.setOnItemClickListener(this);

        //Configurar o retrofit
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BooksService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();*/

        //instanciando o serviço
        //service = retrofit.create(NoticiaService.class);

        //instanciando o presenter
        //presenter = new HomePresenter(this);

        //carregar livros
        //presenter.carregarNoticia();

        //presenter = new HomePresenter(this);


        //list_view_eventos = v.findViewById(R.id.list_view_eventos);

        //txt_teste = v.findViewById(R.id.txt_teste);
        //btn_click = v.findViewById(R.id.btn_click);

       // btn_click.setOnClickListener(click);

        //btn_click.setOnClickListener(this);

        //return v;
    //}

    //@Override
    //public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

       // NoticiaEvento noticiaClicada = noticiaAdapter.getItem(position);

        //O presenter que vai saber oq fazer com este livro
       // presenter.onNoticiaClick(noticiaClicada);


        /*if(noticiaClicada.getNoticia() != null){
            ItemNoticiaFragment itemNoticia = new ItemNoticiaFragment();
            itemNoticia.noticia = noticiaClicada.getNoticia();
            mainActivity.abrirFragment(itemNoticia);

        }else{
            ItemEventoFragment itemEvento = new ItemEventoFragment();
            itemEvento.evento = noticiaClicada.getEvento();
            mainActivity.abrirFragment(itemEvento);
        }

    }*/

    /*@Override
    public void exibirNoticias (List<NoticiaEvento> noticias) {

        //limpando o listview
        noticiaAdapter.clear();

        //adicionando os livros na tela
        noticiaAdapter.addAll(noticias);
    }*/



   /* @Override
    public void exibirMensagem(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT)
                .show();
    }*/

    /*@Override
    public void onClick(View v) {
        txt_teste.setText("texto alterado");

        Toast.makeText(getContext(), "teste oie", Toast.LENGTH_SHORT).show();
    }*/
//}
