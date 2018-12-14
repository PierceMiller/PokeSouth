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

public class Frag4_All_Level_3s extends Fragment {

    View v;
    private RecyclerView myRecyclerView;
    private List<Pokemon> lstFrag1Pokemon;

    public Frag4_All_Level_3s() { }

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

        //LEVEL 3
        lstFrag1Pokemon.add(new Pokemon( "Ninetales", "Normal: 1319 | Boosted: 1649", R.drawable.ic_ninetales, R.drawable.ic_ninetales_stats));
        lstFrag1Pokemon.add(new Pokemon( "Aracanine", "Normal: 1731 | Boosted: 2164", R.drawable.ic_arcanine, R.drawable.ic_arcanine_stats));
        lstFrag1Pokemon.add(new Pokemon( "Alakazam", "Normal: 1747 | Boosted: 2184", R.drawable.ic_alakazam, R.drawable.ic_alakazam_stats));
        lstFrag1Pokemon.add(new Pokemon( "Machamp", "Normal: 1746 | Boosted: 2183", R.drawable.ic_machamp, R.drawable.ic_machamp_stats));
        lstFrag1Pokemon.add(new Pokemon( "Gengar", "Normal: 1644 | Boosted: 2056", R.drawable.ic_gengar, R.drawable.ic_gengar_stats));
        lstFrag1Pokemon.add(new Pokemon( "Onix", "Normal: 629 | Boosted: 787", R.drawable.ic_onix, R.drawable.ic_onix_stats));
        lstFrag1Pokemon.add(new Pokemon( "Hitmonlee", "Normal: 1472 | Boosted: 1840", R.drawable.ic_hitmonlee, R.drawable.ic_hitmonlee_stats));
        lstFrag1Pokemon.add(new Pokemon( "Hitmonchan", "Normal: 1332 | Boosted: 1665", R.drawable.ic_hitmonchan, R.drawable.ic_hitmonchan_stats));
        lstFrag1Pokemon.add(new Pokemon( "Tangela", "Normal: 1278 | Boosted: 1598", R.drawable.ic_tangela, R.drawable.ic_tangela_stats));
        lstFrag1Pokemon.add(new Pokemon( "Starmie", "Normal: 1476 | Boosted: 1846", R.drawable.ic_starmie, R.drawable.ic_starmie_stats));
        lstFrag1Pokemon.add(new Pokemon( "Scyther", "Normal: 1546 | Boosted: 1933", R.drawable.ic_scyther, R.drawable.ic_scyther_stats));
        lstFrag1Pokemon.add(new Pokemon( "Jynx", "Normal: 1460 | Boosted: 1825", R.drawable.ic_jynx, R.drawable.ic_jynx_stats));
        lstFrag1Pokemon.add(new Pokemon( "Pinsir", "Normal: 1690 | Boosted: 2113", R.drawable.ic_pinsir, R.drawable.ic_pinsir_stats));
        lstFrag1Pokemon.add(new Pokemon( "Vaporeon", "Normal: 1779 | Boosted: 2225", R.drawable.ic_vaporeon, R.drawable.ic_vaporeon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Jolteon", "Normal: 1650 | Boosted: 2063", R.drawable.ic_jolteon, R.drawable.ic_jolteon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Flareon", "Normal: 1730 | Boosted: 2163", R.drawable.ic_flareon, R.drawable.ic_flareon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Espeon", "Normal: 1221 | Boosted: 1526", R.drawable.ic_espeon, R.drawable.ic_espeon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Umbreon", "Normal: 1811 | Boosted: 2264", R.drawable.ic_umbreon, R.drawable.ic_umbreon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Porygon", "Normal: 982 | Boosted: 1228", R.drawable.ic_porygon, R.drawable.ic_porygon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Omastar", "Normal: 1592 | Boosted: 1990", R.drawable.ic_omastar, R.drawable.ic_omastar_stats));
        lstFrag1Pokemon.add(new Pokemon( "Kabutops", "Normal: 1550 | Boosted: 1938", R.drawable.ic_kabutops, R.drawable.ic_kabutops_stats));
        lstFrag1Pokemon.add(new Pokemon( "Aerodactyl", "Normal: 1590 | Boosted: 1988", R.drawable.ic_aerodactyl, R.drawable.ic_aerodactyl_stats));
        lstFrag1Pokemon.add(new Pokemon( "Azumarill", "Normal: 907 | Boosted: 1134", R.drawable.ic_azumarill, R.drawable.ic_azumarill_stats));
        lstFrag1Pokemon.add(new Pokemon( "Granbull", "Normal: 1458 | Boosted: 1823", R.drawable.ic_granbull, R.drawable.ic_granbull_stats));
        lstFrag1Pokemon.add(new Pokemon( "Shuckle", "Normal: 231 | Boosted: 289", R.drawable.ic_shuckle, R.drawable.ic_shuckle_stats));
        lstFrag1Pokemon.add(new Pokemon( "Piloswine", "Normal: 1340 | Boosted: 1675", R.drawable.ic_piloswine, R.drawable.ic_piloswine_stats));
        lstFrag1Pokemon.add(new Pokemon( "Donphan", "Normal: 1722 | Boosted: 2152", R.drawable.ic_donphan, R.drawable.ic_donphan_stats));
        lstFrag1Pokemon.add(new Pokemon( "Breloom", "Normal: 1375 | Boosted: 1720", R.drawable.ic_breloom, R.drawable.ic_breloom_stats));
        lstFrag1Pokemon.add(new Pokemon( "Sharpedo", "Normal: 1246 | Boosted: 1558", R.drawable.ic_sharpedo, R.drawable.ic_sharpedo_stats));
        lstFrag1Pokemon.add(new Pokemon( "Lunatone", "Normal: 1330 | Boosted: 1662", R.drawable.ic_lunatone, R.drawable.ic_lunatone_stats));
        lstFrag1Pokemon.add(new Pokemon( "Solrock", "Normal: 1330 | Boosted: 1662", R.drawable.ic_solrock, R.drawable.ic_lunatone_stats));
        lstFrag1Pokemon.add(new Pokemon( "Claydol", "Normal: 1126 | Boosted: 1408", R.drawable.ic_claydol, R.drawable.ic_claydol_stats));
        lstFrag1Pokemon.add(new Pokemon( "Alolan Raichu", "Normal: 1306 | Boosted: 1633", R.drawable.ic_raichu, R.drawable.ic_raichu_stats));
        lstFrag1Pokemon.add(new Pokemon( "Skarmory", "Normal: 903 | Boosted: 1204", R.drawable.ic_skarmory, R.drawable.ic_skarmory_stats));

    }
}
