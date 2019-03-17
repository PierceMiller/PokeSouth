package pokesouth.com.pokesouthapp;

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
        lstFrag1Pokemon.add(new Pokemon( "Deoxys (Attack Forme)", "Normal: 1474 | Boosted: 1842", R.drawable.ic_deoxys_attack, R.drawable.ic_deoxys_attack_stats));
        lstFrag1Pokemon.add(new Pokemon( "Dialga", "Normal: 2307 | Boosted: 2884", R.drawable.ic_dialga, R.drawable.ic_dialga_stats));

        //LEVEL 4
        lstFrag1Pokemon.add(new Pokemon( "Poliwrath", "Normal: 1477 | Boosted: 1847", R.drawable.ic_poliwrath, R.drawable.ic_poliwrath_stats));
        lstFrag1Pokemon.add(new Pokemon( "Alolan Marowak", "Normal: 1048 | Boosted: 1311", R.drawable.ic_alolan_marowak, R.drawable.ic_alolan_marowak_stats));
        lstFrag1Pokemon.add(new Pokemon( "Rhydon", "Normal: 1816 | Boosted: 2270", R.drawable.ic_rhydon, R.drawable.ic_rhydon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Tyranitar", "Normal: 2191 | Boosted: 2739", R.drawable.ic_tyranitar, R.drawable.ic_tyranitar_stats));
        lstFrag1Pokemon.add(new Pokemon( "Absol", "Normal: 1443 | Boosted: 1805", R.drawable.ic_absol, R.drawable.ic_absol_stats));

        //LEVEL 3
        lstFrag1Pokemon.add(new Pokemon( "Alolan Raichu", "Normal: 1306 | Boosted: 1633", R.drawable.ic_raichu, R.drawable.ic_raichu_stats));
        lstFrag1Pokemon.add(new Pokemon( "Machamp", "Normal: 1746 | Boosted: 2183", R.drawable.ic_machamp, R.drawable.ic_machamp_stats));
        lstFrag1Pokemon.add(new Pokemon( "Hitmonlee", "Normal: 1472 | Boosted: 1840", R.drawable.ic_hitmonlee, R.drawable.ic_hitmonlee_stats));
        lstFrag1Pokemon.add(new Pokemon( "Hitmonchan", "Normal: 1332 | Boosted: 1665", R.drawable.ic_hitmonchan, R.drawable.ic_hitmonchan_stats));
        lstFrag1Pokemon.add(new Pokemon( "Donphan", "Normal: 1722 | Boosted: 2152", R.drawable.ic_donphan, R.drawable.ic_donphan_stats));

        //LEVEL 2
        lstFrag1Pokemon.add(new Pokemon( "Mawile", "Normal: 934 | Boosted: 1167", R.drawable.ic_mawile, R.drawable.ic_mawile_stats));
        lstFrag1Pokemon.add(new Pokemon( "Alolan Exeggutor", "Normal: 1722 | Boosted: 2153", R.drawable.ic_alolan_exeggutor, R.drawable.ic_alolan_exeggutor_stats));
        lstFrag1Pokemon.add(new Pokemon( "Combusken", "Normal: 944 | Boosted: 1180", R.drawable.ic_combusken, R.drawable.ic_combusken_stats));
        lstFrag1Pokemon.add(new Pokemon( "Breloom", "Normal: 1502 | Boosted: 1877", R.drawable.ic_breloom, R.drawable.ic_breloom_stats));
        lstFrag1Pokemon.add(new Pokemon( "Monferno", "Normal: 899 | Boosted: 1124", R.drawable.ic_monferno, R.drawable.ic_monferno_stats));

        //LEVEL 1
        lstFrag1Pokemon.add(new Pokemon( "Magikarp", "Normal: 157 | Boosted: 196", R.drawable.ic_magikarp, R.drawable.ic_magikarp_stats));
        lstFrag1Pokemon.add(new Pokemon( "Dratini", "Normal: 574 | Boosted: 717", R.drawable.ic_dratini, R.drawable.ic_dratini_stats));
        lstFrag1Pokemon.add(new Pokemon( "Makuhita", "Normal: 467 | Boosted: 583", R.drawable.ic_makuhita, R.drawable.ic_makuhita_stats));
        lstFrag1Pokemon.add(new Pokemon( "Meditite", "Normal: 396 | Boosted: 495", R.drawable.ic_meditite, R.drawable.ic_meditite_stats));
        lstFrag1Pokemon.add(new Pokemon( "Shinx", "Normal: 500 | Boosted: 625", R.drawable.ic_shinx, R.drawable.ic_shinx_stats));


    }
}
