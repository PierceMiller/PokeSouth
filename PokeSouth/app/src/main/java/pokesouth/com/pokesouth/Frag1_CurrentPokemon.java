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
        lstFrag1Pokemon.add(new Pokemon( "Darkrai", "Normal: 2136 | Boosted: 2671", R.drawable.ic_darkrai, R.drawable.ic_darkrai_stats));

        //LEVEL 4
        lstFrag1Pokemon.add(new Pokemon( "Alolan Marowak", "Normal: 1048 | Boosted: 1311", R.drawable.ic_alolan_marowak, R.drawable.ic_alolan_marowak_stats));
        lstFrag1Pokemon.add(new Pokemon( "Umbreon", "Normal: 1153 | Boosted: 1221", R.drawable.ic_umbreon, R.drawable.ic_umbreon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Tyranitar", "Normal: 2191 | Boosted: 2739", R.drawable.ic_tyranitar, R.drawable.ic_tyranitar_stats));
        lstFrag1Pokemon.add(new Pokemon( "Absol", "Normal: 1443 | Boosted: 1805", R.drawable.ic_absol, R.drawable.ic_absol_stats));

        //LEVEL 3
        lstFrag1Pokemon.add(new Pokemon( "Alolan Raichu", "Normal: 1306 | Boosted: 1633", R.drawable.ic_raichu, R.drawable.ic_raichu_stats));
        lstFrag1Pokemon.add(new Pokemon( "Gengar", "Normal: 1644 | Boosted: 2056", R.drawable.ic_gengar, R.drawable.ic_gengar_stats));
        lstFrag1Pokemon.add(new Pokemon( "Sharpedo", "Normal: 1246 | Boosted: 1558", R.drawable.ic_sharpedo, R.drawable.ic_sharpedo_stats));
        lstFrag1Pokemon.add(new Pokemon( "Skuntank", "Normal: 1347 | Boosted: 1684", R.drawable.ic_skuntank, R.drawable.ic_skuntank_stats));

        //LEVEL 2
        lstFrag1Pokemon.add(new Pokemon( "Sneasel", "Normal: 1172 | Boosted: 1465", R.drawable.ic_sneasel, R.drawable.ic_sneasel_stats));
        lstFrag1Pokemon.add(new Pokemon( "Sableye", "Normal: 843 | Boosted: 1054", R.drawable.ic_sableye, R.drawable.ic_sableye_stats));
        lstFrag1Pokemon.add(new Pokemon( "Mawile", "Normal: 934 | Boosted: 1167", R.drawable.ic_mawile, R.drawable.ic_mawile_stats));
        lstFrag1Pokemon.add(new Pokemon( "Yamask", "Normal: 561 | Boosted: 701", R.drawable.ic_yamask, R.drawable.ic_yamask_stats));

        //LEVEL 1
        lstFrag1Pokemon.add(new Pokemon( "Bulbasaur", "Normal: 637 | Boosted: 796", R.drawable.ic_bulbasaur, R.drawable.ic_bulbasaur_stats));
        lstFrag1Pokemon.add(new Pokemon( "Charmander", "Normal: 560 | Boosted: 700", R.drawable.ic_charmander, R.drawable.ic_charmander_stats));
        lstFrag1Pokemon.add(new Pokemon( "Squirtle", "Normal: 540 | Boosted: 675", R.drawable.ic_squirtle, R.drawable.ic_squirtle_stats));
        lstFrag1Pokemon.add(new Pokemon( "Misdreavus", "Normal: 1100 | Boosted: 1376", R.drawable.ic_misdreavus, R.drawable.ic_misdreavus_stats));
        lstFrag1Pokemon.add(new Pokemon( "Drifloon", "Normal: 684 | Boosted: 855", R.drawable.ic_drifloon, R.drawable.ic_drifloon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Klink", "Normal: 546 | Boosted: 683", R.drawable.ic_klink, R.drawable.ic_mawile_stats));


    }
}
