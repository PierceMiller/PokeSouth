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
        lstFrag1Pokemon.add(new Pokemon( "Armoured Mewtwo", "Normal: 1821 | Boosted: 2276", R.drawable.ic_amewtwo, R.drawable.ic_amewtwo_stats));
        lstFrag1Pokemon.add(new Pokemon( "Deoxys (Speed Forme)", "Normal: 1645 | Boosted: 2056", R.drawable.ic_deoxys_speed, R.drawable.ic_deoxys_stats));

        //LEVEL 4
        lstFrag1Pokemon.add(new Pokemon( "Alolan Marowak", "Normal: 1048 | Boosted: 1311", R.drawable.ic_alolan_marowak, R.drawable.ic_alolan_marowak_stats));
        lstFrag1Pokemon.add(new Pokemon( "Houndoom", "Normal: 1505 | Boosted: 1882", R.drawable.ic_houndoom, R.drawable.ic_houndoom_stats));
        lstFrag1Pokemon.add(new Pokemon( "Tyranitar", "Normal: 2191 | Boosted: 2739", R.drawable.ic_tyranitar, R.drawable.ic_tyranitar_stats));
        lstFrag1Pokemon.add(new Pokemon( "Shiftry", "Normal: 1263 | Boosted: 1333", R.drawable.ic_shiftry, R.drawable.ic_shiftry_stats));
        lstFrag1Pokemon.add(new Pokemon( "Absol", "Normal: 1443 | Boosted: 1805", R.drawable.ic_absol, R.drawable.ic_absol_stats));

        //LEVEL 3
        lstFrag1Pokemon.add(new Pokemon( "Alolan Raichu", "Normal: 1306 | Boosted: 1633", R.drawable.ic_raichu, R.drawable.ic_raichu_stats));
        lstFrag1Pokemon.add(new Pokemon( "Machamp", "Normal: 1746 | Boosted: 2183", R.drawable.ic_machamp, R.drawable.ic_machamp_stats));
        lstFrag1Pokemon.add(new Pokemon( "Gengar", "Normal: 1644 | Boosted: 2056", R.drawable.ic_gengar, R.drawable.ic_gengar_stats));
        lstFrag1Pokemon.add(new Pokemon( "Scyther", "Normal: 1546 | Boosted: 1933", R.drawable.ic_scyther, R.drawable.ic_scyther_stats));
        lstFrag1Pokemon.add(new Pokemon( "Sharpedo", "Normal: 1246 | Boosted: 1558", R.drawable.ic_sharpedo, R.drawable.ic_sharpedo_stats));

        //LEVEL 2
        lstFrag1Pokemon.add(new Pokemon( "Mawile", "Normal: 934 | Boosted: 1167", R.drawable.ic_mawile, R.drawable.ic_mawile_stats));
        lstFrag1Pokemon.add(new Pokemon( "Alolan Exeggutor", "Normal: 1722 | Boosted: 2153", R.drawable.ic_alolan_exeggutor, R.drawable.ic_alolan_exeggutor_stats));
        lstFrag1Pokemon.add(new Pokemon( "Pineco", "Normal: 633 | Boosted: 791", R.drawable.ic_pineco, R.drawable.ic_pineco_stats));
        lstFrag1Pokemon.add(new Pokemon( "Sneasel", "Normal: 1172 | Boosted: 1465", R.drawable.ic_sneasel, R.drawable.ic_sneasel_stats));
        lstFrag1Pokemon.add(new Pokemon( "Mawile", "Normal: 934 | Boosted: 1167", R.drawable.ic_mawile, R.drawable.ic_mawile_stats));

        //LEVEL 1
        lstFrag1Pokemon.add(new Pokemon( "Nidoran", "Normal: 491 | Boosted: 614", R.drawable.ic_nidoran, R.drawable.ic_ninjask_stats));
        lstFrag1Pokemon.add(new Pokemon( "Horsea", "Normal: 603 | Boosted: 754", R.drawable.ic_horsea, R.drawable.ic_wailmer_stats));
        lstFrag1Pokemon.add(new Pokemon( "Shuppet", "Normal: 581 | Boosted: 727", R.drawable.ic_shuppet, R.drawable.ic_shuppet_stats));
        lstFrag1Pokemon.add(new Pokemon( "Duskull", "Normal: 403 | Boosted: 504", R.drawable.ic_duskull, R.drawable.ic_duskull_stats));
        lstFrag1Pokemon.add(new Pokemon( "Shinx", "Normal: 500 | Boosted: 625", R.drawable.ic_shinx, R.drawable.ic_shinx_stats));
        lstFrag1Pokemon.add(new Pokemon( "Drifloon", "Normal: 684 | Boosted: 855", R.drawable.ic_drifloon, R.drawable.ic_drifloon_stats));
     }
}
