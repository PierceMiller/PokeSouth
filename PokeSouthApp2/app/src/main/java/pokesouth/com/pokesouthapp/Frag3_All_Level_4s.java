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

public class Frag3_All_Level_4s extends Fragment {

    View v;
    private RecyclerView myRecyclerView;
    private List<Pokemon> lstFrag1Pokemon;

    public Frag3_All_Level_4s() { }

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

        //LEVEL 4
        lstFrag1Pokemon.add(new Pokemon( "Venusaur", "Normal: 1554 | Boosted: 1943", R.drawable.ic_venusaur, R.drawable.ic_venusaur_stats));
        lstFrag1Pokemon.add(new Pokemon( "Charizard", "Normal: 1535 | Boosted: 1918", R.drawable.ic_charizard, R.drawable.ic_charizard_stats));
        lstFrag1Pokemon.add(new Pokemon( "Blastoise", "Normal: 1409 | Boosted: 1761", R.drawable.ic_blastoise, R.drawable.ic_tyranitar_stats));
        lstFrag1Pokemon.add(new Pokemon( "Pikachu", "Normal: 536 | Boosted: 670", R.drawable.ic_pikachu, R.drawable.ic_pikachu_stats));
        lstFrag1Pokemon.add(new Pokemon( "Nidoqueen", "Normal: 1421 | Boosted: 1777", R.drawable.ic_nidoqueen, R.drawable.ic_nidoking_queen_stats));
        lstFrag1Pokemon.add(new Pokemon( "Nidoking", "Normal: 1466 | Boosted: 1833", R.drawable.ic_nidoking, R.drawable.ic_nidoking_queen_stats));
        lstFrag1Pokemon.add(new Pokemon( "Meowth", "Normal: 427 | Boosted: 534", R.drawable.ic_mewoth, R.drawable.ic_meowth_stats));
        lstFrag1Pokemon.add(new Pokemon( "Poliwrath", "Normal: 1477 | Boosted: 1847", R.drawable.ic_poliwrath, R.drawable.ic_poliwrath_stats));
        lstFrag1Pokemon.add(new Pokemon( "Victreebel", "Normal: 1389 | Boosted: 1736", R.drawable.ic_victreebel, R.drawable.ic_victreebel_stats));
        lstFrag1Pokemon.add(new Pokemon( "Golem", "Normal: 1685 | Boosted: 2106", R.drawable.ic_golem, R.drawable.ic_golem_stats));
        lstFrag1Pokemon.add(new Pokemon( "Rhydon", "Normal: 1816 | Boosted: 2270", R.drawable.ic_rhydon, R.drawable.ic_rhydon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Lapras", "Normal: 1509 | Boosted: 1886", R.drawable.ic_lapras, R.drawable.ic_lapras_stats));
        lstFrag1Pokemon.add(new Pokemon( "Snorlax", "Normal: 1843 | Boosted: 2304", R.drawable.ic_snorlax, R.drawable.ic_snorlax_stats));
        lstFrag1Pokemon.add(new Pokemon( "Dragonite", "Normal: 2167 | Boosted: 2709", R.drawable.ic_dragonite, R.drawable.ic_dragonite_stats));
        lstFrag1Pokemon.add(new Pokemon( "Feraligatr", "Normal: 1632 | Boosted: 2040", R.drawable.ic_feraligatr, R.drawable.ic_feraligatr_stats));
        lstFrag1Pokemon.add(new Pokemon( "Togetic", "Normal: 976 | Boosted: 1220", R.drawable.ic_togetic, R.drawable.ic_togetic_stats));
        lstFrag1Pokemon.add(new Pokemon( "Wobbuffet", "Normal: 586 | Boosted: 733", R.drawable.ic_wobbuffet, R.drawable.ic_wobbuffet_stats));
        lstFrag1Pokemon.add(new Pokemon( "Ursaring", "Normal: 1682 | Boosted: 2103", R.drawable.ic_ursaring, R.drawable.ic_ursaring_stats));
        lstFrag1Pokemon.add(new Pokemon( "Houndoom", "Normal: 1505 | Boosted: 1882", R.drawable.ic_houndoom, R.drawable.ic_houndoom_stats));
        lstFrag1Pokemon.add(new Pokemon( "Tyranitar", "Normal: 2191 | Boosted: 2739", R.drawable.ic_tyranitar, R.drawable.ic_tyranitar_stats));
        lstFrag1Pokemon.add(new Pokemon( "Aggron", "Normal: 1714 | Boosted: 2143", R.drawable.ic_aggron, R.drawable.ic_aggron_stats));
        lstFrag1Pokemon.add(new Pokemon( "Absol", "Normal: 1443 | Boosted: 1805", R.drawable.ic_absol, R.drawable.ic_absol_stats));
        lstFrag1Pokemon.add(new Pokemon( "Walrein", "Normal: 1557 | Boosted: 1947", R.drawable.ic_walrein, R.drawable.ic_walrein_stats));
        lstFrag1Pokemon.add(new Pokemon( "Alolan Exeggutor", "Normal: 1722 | Boosted: 2153", R.drawable.ic_alolan_exeggutor, R.drawable.ic_alolan_exeggutor_stats));
        lstFrag1Pokemon.add(new Pokemon( "Alolan Marowak", "Normal: 1048 | Boosted: 1311", R.drawable.ic_alolan_marowak, R.drawable.ic_alolan_marowak_stats));

    }
}
