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
        lstFrag1Pokemon.add(new Pokemon( "Mewtwo", "Normal: 2387 | Boosted: 2984", R.drawable.ic_mewtwo, R.drawable.ic_mewtwo_stats));
        lstFrag1Pokemon.add(new Pokemon( "Cobalion", "Normal: 1727 | Boosted: 2159", R.drawable.ic_cobalion, R.drawable.ic_cobalion_stats));

        //LEVEL 4
        lstFrag1Pokemon.add(new Pokemon( "Charizard", "Normal: 1535 | Boosted: 1918", R.drawable.ic_charizard, R.drawable.ic_charizard_stats));
        lstFrag1Pokemon.add(new Pokemon( "Alolan Marowak", "Normal: 1048 | Boosted: 1311", R.drawable.ic_alolan_marowak, R.drawable.ic_alolan_marowak_stats));
        lstFrag1Pokemon.add(new Pokemon( "Tyranitar", "Normal: 2191 | Boosted: 2739", R.drawable.ic_tyranitar, R.drawable.ic_tyranitar_stats));
        lstFrag1Pokemon.add(new Pokemon( "Blaziken", "Normal: 1627 | Boosted: 2034", R.drawable.ic_blaziken, R.drawable.ic_entei_stats));
        lstFrag1Pokemon.add(new Pokemon( "Absol", "Normal: 1443 | Boosted: 1805", R.drawable.ic_absol, R.drawable.ic_absol_stats));

        //LEVEL 3
        lstFrag1Pokemon.add(new Pokemon( "Alolan Raichu", "Normal: 1306 | Boosted: 1633", R.drawable.ic_raichu, R.drawable.ic_raichu_stats));
        lstFrag1Pokemon.add(new Pokemon( "Ninetales", "Normal: 1302 | Boosted: 1628", R.drawable.ic_ninetales, R.drawable.ic_ninetales_stats));
        lstFrag1Pokemon.add(new Pokemon( "Machamp", "Normal: 1746 | Boosted: 2183", R.drawable.ic_machamp, R.drawable.ic_machamp_stats));
        lstFrag1Pokemon.add(new Pokemon( "Flareon", "Normal: 1730 | Boosted: 2163", R.drawable.ic_flareon, R.drawable.ic_flareon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Hariyama", "Normal: 1616 | Boosted: 2020", R.drawable.ic_hariyama, R.drawable.ic_machamp_stats));

        //LEVEL 2
        lstFrag1Pokemon.add(new Pokemon( "Alolan Exeggutor", "Normal: 1722 | Boosted: 2153", R.drawable.ic_alolan_exeggutor, R.drawable.ic_alolan_exeggutor_stats));
        lstFrag1Pokemon.add(new Pokemon( "Magmar", "Normal: 1367 | Boosted: 1710", R.drawable.ic_magmar, R.drawable.ic_magmar_stats));
        lstFrag1Pokemon.add(new Pokemon( "Quilava", "Normal: 944 | Boosted: 1180", R.drawable.ic_quilava, R.drawable.ic_quilava_stats));
        lstFrag1Pokemon.add(new Pokemon( "Magcargo", "Normal: 972 | Boosted: 1215", R.drawable.ic_magcargo, R.drawable.ic_magcargo_stats));

        //LEVEL 1
        lstFrag1Pokemon.add(new Pokemon( "Mankey", "Normal: 665 | Boosted: 832", R.drawable.ic_mankey, R.drawable.ic_machamp_stats));
        lstFrag1Pokemon.add(new Pokemon( "Growlithe", "Normal: 710 | Boosted: 888", R.drawable.ic_growlith, R.drawable.ic_entei_stats));
        lstFrag1Pokemon.add(new Pokemon( "Houndour", "Normal: 705 | Boosted: 881", R.drawable.ic_houndour, R.drawable.ic_houndoom_stats));
        lstFrag1Pokemon.add(new Pokemon( "Meditite", "Normal: 396 | Boosted: 495", R.drawable.ic_meditite, R.drawable.ic_meditite_stats));
        lstFrag1Pokemon.add(new Pokemon( "Shinx", "Normal: 500 | Boosted: 625", R.drawable.ic_shinx, R.drawable.ic_shinx_stats));
        lstFrag1Pokemon.add(new Pokemon( "Croagunk", "Normal: 544 | Boosted: 680", R.drawable.ic_croagunk, R.drawable.ic_muk_stats));
        lstFrag1Pokemon.add(new Pokemon( "Klink", "Normal: 546 | Boosted: 683", R.drawable.ic_klink, R.drawable.ic_mawile_stats));



    }
}
