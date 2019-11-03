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


public class Frag2_All_Level_5s extends Fragment {

    View v;
    private RecyclerView myRecyclerView;
    private List<Pokemon> lstFrag1Pokemon;

    public Frag2_All_Level_5s() { }

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
        lstFrag1Pokemon.add(new Pokemon( "Articuno", "Normal: 1743 | Boosted: 2179", R.drawable.ic_articuno, R.drawable.ic_articuno_stats));
        lstFrag1Pokemon.add(new Pokemon( "Zapdos", "Normal: 2015 | Boosted: 2519", R.drawable.ic_zapdos, R.drawable.ic_zapdos_stats));
        lstFrag1Pokemon.add(new Pokemon( "Moltres", "Normal: 1980 | Boosted: 2475", R.drawable.ic_moltres, R.drawable.ic_moltres_stats));
        lstFrag1Pokemon.add(new Pokemon( "Mewtwo", "Normal: 2387 | Boosted: 2984", R.drawable.ic_mewtwo, R.drawable.ic_mewtwo_stats));
        lstFrag1Pokemon.add(new Pokemon( "Raikou", "Normal: 1972 | Boosted: 2466", R.drawable.ic_raikou, R.drawable.ic_raikou_stats));
        lstFrag1Pokemon.add(new Pokemon( "Entei", "Normal: 1984 | Boosted: 2480", R.drawable.ic_entei, R.drawable.ic_entei_stats));
        lstFrag1Pokemon.add(new Pokemon( "Suicune", "Normal: 1704 | Boosted: 2130", R.drawable.ic_suicune, R.drawable.ic_suicune_stats));
        lstFrag1Pokemon.add(new Pokemon( "Lugia", "Normal: 2115 | Boosted: 2645", R.drawable.ic_lugia, R.drawable.ic_lugia_stats));
        lstFrag1Pokemon.add(new Pokemon( "Ho-oh", "Normal: 2207 | Boosted: 2759", R.drawable.ic_ho_oh, R.drawable.ic_hooh_stats));
        lstFrag1Pokemon.add(new Pokemon( "Regirock", "Normal: 1784 | Boosted: 2230", R.drawable.ic_regirock, R.drawable.ic_regirock_stats));
        lstFrag1Pokemon.add(new Pokemon( "Regice", "Normal: 1784 | Boosted: 2230", R.drawable.ic_regice, R.drawable.ic_regice_stats));
        lstFrag1Pokemon.add(new Pokemon( "Registeel", "Normal: 1398 | Boosted: 1748", R.drawable.ic_registeel, R.drawable.ic_registeel_stats));
        lstFrag1Pokemon.add(new Pokemon( "Latias", "Normal: 2006 | Boosted: 2507", R.drawable.ic_latias, R.drawable.ic_latias_stats));
        lstFrag1Pokemon.add(new Pokemon( "Latios", "Normal: 2178 | Boosted: 2723", R.drawable.ic_latios, R.drawable.ic_latios_stats));
        lstFrag1Pokemon.add(new Pokemon( "Kyogre", "Normal: 2351 | Boosted: 2939", R.drawable.ic_kyogre, R.drawable.ic_kyogre_stats));
        lstFrag1Pokemon.add(new Pokemon( "Groudon", "Normal: 2351 | Boosted: 2939", R.drawable.ic_groudon, R.drawable.ic_groudon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Rayquaza", "Normal: 2191 | Boosted: 2739", R.drawable.ic_rayquaza, R.drawable.ic_rayquaza_stats));
        lstFrag1Pokemon.add(new Pokemon( "Jirachi", "Normal: 1865 | Boosted: 2332", R.drawable.ic_jirachi, R.drawable.ic_jirachi_stats));
        lstFrag1Pokemon.add(new Pokemon( "Deoxys (Normal Forme)", "Normal: 1806 | Boosted: 2257", R.drawable.ic_deoxys_normal, R.drawable.ic_deoxys_stats));
        lstFrag1Pokemon.add(new Pokemon( "Deoxys (Defence Forme)", "Normal: 1299 | Boosted: 1624", R.drawable.ic_deoxys_defense, R.drawable.ic_deoxys_stats));
        lstFrag1Pokemon.add(new Pokemon( "Deoxys (Attack Forme)", "Normal: 1474 | Boosted: 1842", R.drawable.ic_deoxys_attack, R.drawable.ic_deoxys_attack_stats));
        lstFrag1Pokemon.add(new Pokemon( "Giratina (Altered)", "Normal: 1931 | Boosted: 2414", R.drawable.ic_giratina, R.drawable.ic_giratina_stats));
        lstFrag1Pokemon.add(new Pokemon( "Giratina (Origin)", "Normal: 2105 | Boosted: 2631", R.drawable.ic_giratina_origin, R.drawable.ic_giratina_stats));
        lstFrag1Pokemon.add(new Pokemon( "Cresselia", "Normal: 1633 | Boosted: 2041", R.drawable.ic_cresselia, R.drawable.ic_cresselia_stats));
        lstFrag1Pokemon.add(new Pokemon( "Heatran", "Normal: 2145 | Boosted: 2681", R.drawable.ic_heatran, R.drawable.ic_heatran_stats));
        lstFrag1Pokemon.add(new Pokemon( "Palkia", "Normal: 2280 | Boosted: 2850", R.drawable.ic_palkia, R.drawable.ic_palkia_stats));
        lstFrag1Pokemon.add(new Pokemon( "Dialga", "Normal: 2307 | Boosted: 2884", R.drawable.ic_dialga, R.drawable.ic_dialga_stats));
        lstFrag1Pokemon.add(new Pokemon( "Azelf", "Normal: 1834 | Boosted: 2293", R.drawable.ic_azelf, R.drawable.ic_uxie_stats));
        lstFrag1Pokemon.add(new Pokemon( "Mesprit", "Normal: 1747 | Boosted: 2184", R.drawable.ic_mesprit, R.drawable.ic_uxie_stats));
        lstFrag1Pokemon.add(new Pokemon( "Uxie", "Normal: 1442 | Boosted: 1803", R.drawable.ic_uxie, R.drawable.ic_uxie_stats));
        lstFrag1Pokemon.add(new Pokemon( "Darkrai", "Normal: 2136 | Boosted: 2671", R.drawable.ic_darkrai, R.drawable.ic_darkrai_stats));

    }
}
