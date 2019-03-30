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
        lstFrag1Pokemon.add(new Pokemon( "Giratina (Altered)", "Normal: 1931 | Boosted: 2414", R.drawable.ic_giratina, R.drawable.ic_giratina_stats));

        //LEVEL 4
        lstFrag1Pokemon.add(new Pokemon( "Alolan Marowak", "Normal: 1048 | Boosted: 1311", R.drawable.ic_alolan_marowak, R.drawable.ic_alolan_marowak_stats));
        lstFrag1Pokemon.add(new Pokemon( "Dragonite", "Normal: 2167 | Boosted: 2709", R.drawable.ic_dragonite, R.drawable.ic_dragonite_stats));
        lstFrag1Pokemon.add(new Pokemon( "Togetic", "Normal: 976 | Boosted: 1220", R.drawable.ic_togetic, R.drawable.ic_togetic_stats));
        lstFrag1Pokemon.add(new Pokemon( "Houndoom", "Normal: 1505 | Boosted: 1882", R.drawable.ic_houndoom, R.drawable.ic_houndoom_stats));
        lstFrag1Pokemon.add(new Pokemon( "Absol", "Normal: 1443 | Boosted: 1805", R.drawable.ic_absol, R.drawable.ic_absol_stats));

        //LEVEL 3
        lstFrag1Pokemon.add(new Pokemon( "Alolan Raichu", "Normal: 1306 | Boosted: 1633", R.drawable.ic_raichu, R.drawable.ic_raichu_stats));
        lstFrag1Pokemon.add(new Pokemon( "Machamp", "Normal: 1746 | Boosted: 2183", R.drawable.ic_machamp, R.drawable.ic_machamp_stats));
        lstFrag1Pokemon.add(new Pokemon( "Gengar", "Normal: 1644 | Boosted: 2056", R.drawable.ic_gengar, R.drawable.ic_gengar_stats));
        lstFrag1Pokemon.add(new Pokemon( "Granbull", "Normal: 1458 | Boosted: 1823", R.drawable.ic_granbull, R.drawable.ic_granbull_stats));
        lstFrag1Pokemon.add(new Pokemon( "Piloswine", "Normal: 1340 | Boosted: 1675", R.drawable.ic_piloswine, R.drawable.ic_piloswine_stats));

        //LEVEL 2
        lstFrag1Pokemon.add(new Pokemon( "Alolan Exeggutor", "Normal: 1722 | Boosted: 2153", R.drawable.ic_alolan_exeggutor, R.drawable.ic_alolan_exeggutor_stats));
        lstFrag1Pokemon.add(new Pokemon( "Misdreavus", "Normal: 1100 | Boosted: 1376", R.drawable.ic_misdreavus, R.drawable.ic_misdreavus_stats));
        lstFrag1Pokemon.add(new Pokemon( "Sneasel", "Normal: 1172 | Boosted: 1465", R.drawable.ic_sneasel, R.drawable.ic_sneasel_stats));
        lstFrag1Pokemon.add(new Pokemon( "Sableye", "Normal: 843 | Boosted: 1054", R.drawable.ic_sableye, R.drawable.ic_sableye_stats));
        lstFrag1Pokemon.add(new Pokemon( "Mawile", "Normal: 934 | Boosted: 1167", R.drawable.ic_mawile, R.drawable.ic_mawile_stats));

        //LEVEL 1
        lstFrag1Pokemon.add(new Pokemon( "Snorunt", "Normal: 441 | Boosted: 551", R.drawable.ic_snorunt, R.drawable.ic_snorunt_stats));
        lstFrag1Pokemon.add(new Pokemon( "Bagon", "Normal: 660 | Boosted: 826", R.drawable.ic_bagon, R.drawable.ic_bagon_stats));
        lstFrag1Pokemon.add(new Pokemon( "Shinx", "Normal: 500 | Boosted: 625", R.drawable.ic_shinx, R.drawable.ic_shinx_stats));
        lstFrag1Pokemon.add(new Pokemon( "Drifloon", "Normal: 684 | Boosted: 855", R.drawable.ic_drifloon, R.drawable.ic_drifloon_stats));
    }
}
