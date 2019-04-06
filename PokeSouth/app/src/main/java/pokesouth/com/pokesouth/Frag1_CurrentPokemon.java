package pokesouth.com.pokesouth;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Frag1_CurrentPokemon extends Fragment {

    View v;
    private RecyclerView myRecyclerView;
    private List<Pokemon> lstFrag1Pokemon;

    public Frag1_CurrentPokemon() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.pokemon_fragment,container, false);
        myRecyclerView = (RecyclerView) v.findViewById(R.id.pokemon_recyclerview);
        RecycleViewAdapter frag1Adapter = new RecycleViewAdapter(getContext(), lstFrag1Pokemon);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(frag1Adapter);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstFrag1Pokemon = new ArrayList<>();

        //LEVEL 5
        lstFrag1Pokemon.add(new Pokemon( "Deoxys (Defence Forme)", "Normal: 1299 | Boosted: 1624", R.drawable.ic_deoxys_defense, R.drawable.ic_deoxys_stats));
        lstFrag1Pokemon.add(new Pokemon( "Giratina (Origin)", "Normal: 2105 | Boosted: 2631", R.drawable.ic_giratina_origin, R.drawable.ic_giratina_stats));

        //LEVEL 4
        lstFrag1Pokemon.add(new Pokemon( "Alolan Marowak", "Normal: 1048 | Boosted: 1311", R.drawable.ic_alolan_marowak, R.drawable.ic_alolan_marowak_stats));
        lstFrag1Pokemon.add(new Pokemon( "Tyranitar", "Normal: 2191 | Boosted: 2739", R.drawable.ic_tyranitar, R.drawable.ic_tyranitar_stats));
        lstFrag1Pokemon.add(new Pokemon( "Ninjask", "Normal: 1125 | Boosted: 1406", R.drawable.ic_ninjask, R.drawable.ic_ninjask_stats));
        lstFrag1Pokemon.add(new Pokemon( "Absol", "Normal: 1443 | Boosted: 1805", R.drawable.ic_absol, R.drawable.ic_absol_stats));

        //LEVEL 3
        lstFrag1Pokemon.add(new Pokemon( "Alolan Raichu", "Normal: 1306 | Boosted: 1633", R.drawable.ic_raichu, R.drawable.ic_raichu_stats));
        lstFrag1Pokemon.add(new Pokemon( "Machamp", "Normal: 1746 | Boosted: 2183", R.drawable.ic_machamp, R.drawable.ic_machamp_stats));
        lstFrag1Pokemon.add(new Pokemon( "Scyther", "Normal: 1546 | Boosted: 1933", R.drawable.ic_scyther, R.drawable.ic_scyther_stats));
        lstFrag1Pokemon.add(new Pokemon( "Pinsir", "Normal: 1690 | Boosted: 2113", R.drawable.ic_pinsir, R.drawable.ic_pinsir_stats));
        lstFrag1Pokemon.add(new Pokemon( "Shuckle", "Normal: 231 | Boosted: 289", R.drawable.ic_shuckle, R.drawable.ic_shuckle_stats));

        //LEVEL 2
        lstFrag1Pokemon.add(new Pokemon( "Exeggutor", "Normal: 1722 | Boosted: 2153", R.drawable.ic_exeggutor, R.drawable.ic_exeggutor_stats));
        lstFrag1Pokemon.add(new Pokemon( "Pineco", "Normal: 633 | Boosted: 791", R.drawable.ic_pineco, R.drawable.ic_pineco_stats));
        lstFrag1Pokemon.add(new Pokemon( "Masquerian", "Normal: 1297 | Boosted: 1622", R.drawable.ic_masquerian, R.drawable.ic_ninjask_stats));
        lstFrag1Pokemon.add(new Pokemon( "Mawile", "Normal: 934 | Boosted: 1167", R.drawable.ic_mawile, R.drawable.ic_mawile_stats));
        lstFrag1Pokemon.add(new Pokemon( "Combee", "Normal: 282 | Boosted: 353", R.drawable.ic_combee, R.drawable.ic_ninjask_stats));

        //LEVEL 1
        lstFrag1Pokemon.add(new Pokemon( "Caterpie", "Normal: 249 | Boosted: 312", R.drawable.ic_caterpie, R.drawable.ic_ninjask_stats));
        lstFrag1Pokemon.add(new Pokemon( "Kricketot", "Normal: 229 | Boosted: 286", R.drawable.ic_kricketot, R.drawable.ic_kricketot_stats));
        lstFrag1Pokemon.add(new Pokemon( "Shinx", "Normal: 500 | Boosted: 625", R.drawable.ic_shinx, R.drawable.ic_shinx_stats));
        lstFrag1Pokemon.add(new Pokemon( "Skorupi", "Normal: 576 | Boosted: 721", R.drawable.ic_skorupi, R.drawable.ic_ninjask_stats));

       }
}
