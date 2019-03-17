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

public class Frag6_All_Level_1s extends Fragment {

    View v;
    private RecyclerView myRecyclerView;
    private List<Pokemon> lstFrag1Pokemon;

    public Frag6_All_Level_1s() { }

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

        //TODO: ADD MAGNEMITE

        //LEVEL 1
        lstFrag1Pokemon.add(new Pokemon( "Bulbasaur", "Normal: 637 | Boosted: 796", R.drawable.ic_bulbasaur, R.drawable.ic_bulbasaur_stats));
        lstFrag1Pokemon.add(new Pokemon( "Ivysaur", "Normal: 970 | Boosted: 1213", R.drawable.ic_ivysaur, R.drawable.ic_ivysaur_stats));
        lstFrag1Pokemon.add(new Pokemon( "Charmander", "Normal: 560 | Boosted: 700", R.drawable.ic_charmander, R.drawable.ic_charmander_stats));
        lstFrag1Pokemon.add(new Pokemon( "Charmeleon", "Normal: 944 | Boosted: 1180", R.drawable.ic_charmeleon, R.drawable.ic_charmeleon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Squirtle", "Normal: 540 | Boosted: 675", R.drawable.ic_squirtle, R.drawable.ic_squirtle_stats));
        lstFrag1Pokemon.add(new Pokemon( "Wartortle", "Normal: 850 | Boosted: 1063", R.drawable.ic_wartortle, R.drawable.ic_wartortle_stats));
        lstFrag1Pokemon.add(new Pokemon( "Metapod", "Normal: 257 | Boosted: 321", R.drawable.ic_metapod, R.drawable.ic_metapod_stats));
        lstFrag1Pokemon.add(new Pokemon( "Magnemite", "Normal: 778 | Boosted: 973", R.drawable.ic_magnemite, R.drawable.ic_magnemite_stats));
        lstFrag1Pokemon.add(new Pokemon( "Shellder", "Normal: 617 | Boosted: 771", R.drawable.ic_shellder, R.drawable.ic_shellder_stats));
        lstFrag1Pokemon.add(new Pokemon( "Drowzee", "Normal: 594 | Boosted: 743", R.drawable.ic_drowzee, R.drawable.ic_drowzee_stats));
        lstFrag1Pokemon.add(new Pokemon( "Magikarp", "Normal: 157 | Boosted: 196", R.drawable.ic_magikarp, R.drawable.ic_magikarp_stats));
        lstFrag1Pokemon.add(new Pokemon( "Omanyte", "Normal: 882 | Boosted: 1103", R.drawable.ic_omanyte, R.drawable.ic_omanyte_stats));
        lstFrag1Pokemon.add(new Pokemon( "Kabuto", "Normal: 783 | Boosted: 979", R.drawable.ic_kabuto, R.drawable.ic_kabuto_stats));
        lstFrag1Pokemon.add(new Pokemon( "Dratini", "Normal: 574 | Boosted: 717", R.drawable.ic_dratini, R.drawable.ic_dratini_stats));
        lstFrag1Pokemon.add(new Pokemon( "Chikorita", "Normal: 534 | Boosted: 668", R.drawable.ic_chikorita, R.drawable.ic_chikorita_stats));
        lstFrag1Pokemon.add(new Pokemon( "Bayleef", "Normal: 831 | Boosted: 1039", R.drawable.ic_bayleef, R.drawable.ic_bayleef_stats));
        lstFrag1Pokemon.add(new Pokemon( "Cyndaquil", "Normal: 560 | Boosted: 700", R.drawable.ic_cyndaquil, R.drawable.ic_cyndaquil_stats));
        lstFrag1Pokemon.add(new Pokemon( "Quilava", "Normal: 944 | Boosted: 1180", R.drawable.ic_quilava, R.drawable.ic_quilava_stats));
        lstFrag1Pokemon.add(new Pokemon( "Totodile", "Normal: 646 | Boosted: 808", R.drawable.ic_totodile, R.drawable.ic_totodile_stats));
        lstFrag1Pokemon.add(new Pokemon( "Mareep", "Normal: 566 | Boosted: 708", R.drawable.ic_mareep, R.drawable.ic_mareep_stats));
        lstFrag1Pokemon.add(new Pokemon( "Sunkern", "Normal: 226 | Boosted: 282", R.drawable.ic_sunkern, R.drawable.ic_sunkern_stats));
        lstFrag1Pokemon.add(new Pokemon( "Yanma", "Normal: 840 | Boosted: 1050", R.drawable.ic_yanma, R.drawable.ic_yanma_stats));
        lstFrag1Pokemon.add(new Pokemon( "Makuhita", "Normal: 467 | Boosted: 583", R.drawable.ic_makuhita, R.drawable.ic_makuhita_stats));
        lstFrag1Pokemon.add(new Pokemon( "Meditite", "Normal: 396 | Boosted: 495", R.drawable.ic_meditite, R.drawable.ic_meditite_stats));
        lstFrag1Pokemon.add(new Pokemon( "Wailmer", "Normal: 838 | Boosted: 1048", R.drawable.ic_wailmer, R.drawable.ic_wailmer_stats));
        lstFrag1Pokemon.add(new Pokemon( "Swablu", "Normal: 470 | Boosted: 588", R.drawable.ic_swablu, R.drawable.ic_swablu_stats));
        lstFrag1Pokemon.add(new Pokemon( "Lileep", "Normal: 738 | Boosted: 922", R.drawable.ic_lileep, R.drawable.ic_lileep_stats));
        lstFrag1Pokemon.add(new Pokemon( "Anorith", "Normal: 874 | Boosted: 1092", R.drawable.ic_anorith, R.drawable.ic_anorith_stats));
        lstFrag1Pokemon.add(new Pokemon( "Shuppet", "Normal: 581 | Boosted: 727", R.drawable.ic_shuppet, R.drawable.ic_shuppet_stats));
        lstFrag1Pokemon.add(new Pokemon( "Duskull", "Normal: 403 | Boosted: 504", R.drawable.ic_duskull, R.drawable.ic_duskull_stats));
        lstFrag1Pokemon.add(new Pokemon( "Snorunt", "Normal: 441 | Boosted: 551", R.drawable.ic_snorunt, R.drawable.ic_snorunt_stats));
        lstFrag1Pokemon.add(new Pokemon( "Bidoof", "Normal: 412 | Boosted: 515", R.drawable.ic_bidoof, R.drawable.ic_bidoof_stats));
        lstFrag1Pokemon.add(new Pokemon( "Kricketot", "Normal: 229 | Boosted: 286", R.drawable.ic_kricketot, R.drawable.ic_kricketot_stats));
        lstFrag1Pokemon.add(new Pokemon( "Shinx", "Normal: 500 | Boosted: 625", R.drawable.ic_shinx, R.drawable.ic_shinx_stats));
        lstFrag1Pokemon.add(new Pokemon( "Buizel", "Normal: 602 | Boosted: 753", R.drawable.ic_buizel, R.drawable.ic_buizel_stats));
        lstFrag1Pokemon.add(new Pokemon( "Buneary", "Normal: 602 | Boosted: 753", R.drawable.ic_buneary, R.drawable.ic_buneary_stats));
        lstFrag1Pokemon.add(new Pokemon( "Drifloon", "Normal: 684 | Boosted: 855", R.drawable.ic_drifloon, R.drawable.ic_drifloon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Plusle", "Normal: 1016 | Boosted: 1270", R.drawable.ic_plusle, R.drawable.ic_plusle_stats));
        lstFrag1Pokemon.add(new Pokemon( "Minun", "Normal: 968 | Boosted: 1210", R.drawable.ic_minun, R.drawable.ic_plusle_stats));
        lstFrag1Pokemon.add(new Pokemon( "Wingull", "Normal: 437 | Boosted: 546", R.drawable.ic_wingull, R.drawable.ic_wingull_stats));
    }
}
