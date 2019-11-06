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

public class Frag5_All_Level_2s extends Fragment {

    View v;
    private RecyclerView myRecyclerView;
    private List<Pokemon> lstFrag1Pokemon;

    public Frag5_All_Level_2s() { }

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

        //LEVEL 2
        lstFrag1Pokemon.add(new Pokemon( "Sandslash", "Normal: 1330 | Boosted: 1663", R.drawable.ic_sandslash, R.drawable.ic_sandslash_stats));
        lstFrag1Pokemon.add(new Pokemon( "Venomoth", "Normal: 1107 | Boosted: 1384", R.drawable.ic_venomoth, R.drawable.ic_venomoth_stats));
        lstFrag1Pokemon.add(new Pokemon( "Primeape", "Normal: 1203 | Boosted: 1955", R.drawable.ic_primeape, R.drawable.ic_primeape_stats));
        lstFrag1Pokemon.add(new Pokemon( "Tentacruel", "Normal: 1356 | Boosted: 1695", R.drawable.ic_tentacruel, R.drawable.ic_tentacruel_stats));
        lstFrag1Pokemon.add(new Pokemon( "Slowbro", "Normal: 1454 | Boosted: 1817", R.drawable.ic_slowbro, R.drawable.ic_slowbro_stats));
        lstFrag1Pokemon.add(new Pokemon( "Magneton", "Normal: 1420 | Boosted: 1775", R.drawable.ic_magneton, R.drawable.ic_magneton_stats));
        lstFrag1Pokemon.add(new Pokemon( "Dewgong", "Normal: 1134 | Boosted: 1418", R.drawable.ic_dewgong, R.drawable.ic_dewgong_stats));
        lstFrag1Pokemon.add(new Pokemon( "Muk", "Normal: 1575 | Boosted: 1969", R.drawable.ic_muk, R.drawable.ic_muk_stats));
        lstFrag1Pokemon.add(new Pokemon( "Cloyster", "Normal: 1455 | Boosted: 1819", R.drawable.ic_cloyster, R.drawable.ic_cloyster_stats));
        lstFrag1Pokemon.add(new Pokemon( "Exeggutor", "Normal: 1722 | Boosted: 2153", R.drawable.ic_exeggutor, R.drawable.ic_exeggutor_stats));
        lstFrag1Pokemon.add(new Pokemon( "Marowak", "Normal: 1048 | Boosted: 1311", R.drawable.ic_marowak, R.drawable.ic_marowak_stats));
        lstFrag1Pokemon.add(new Pokemon( "Lickitung", "Normal: 806 | Boosted: 1008", R.drawable.ic_lickitung, R.drawable.ic_lickitung_stats));
        lstFrag1Pokemon.add(new Pokemon( "Weezing", "Normal: 1310 | Boosted: 1637", R.drawable.ic_weezing, R.drawable.ic_weezing_stats));
        lstFrag1Pokemon.add(new Pokemon( "Electabuzz", "Normal: 1333 | Boosted: 1667", R.drawable.ic_electabuzz, R.drawable.ic_electabuzz_stats));
        lstFrag1Pokemon.add(new Pokemon( "Magmar", "Normal: 1367 | Boosted: 1710", R.drawable.ic_magmar, R.drawable.ic_magmar_stats));
        lstFrag1Pokemon.add(new Pokemon( "Crocconaw", "Normal: 984 | Boosted: 1230", R.drawable.ic_croconaw, R.drawable.ic_croconaw_stats));
        lstFrag1Pokemon.add(new Pokemon( "Lanturn", "Normal: 1191 | Boosted: 1489", R.drawable.ic_lanturn, R.drawable.ic_lanturn_stats));
        lstFrag1Pokemon.add(new Pokemon( "Sudowoodo", "Normal: 1227 | Boosted: 1534", R.drawable.ic_sudowoodo, R.drawable.ic_sudowoodo_stats));
        lstFrag1Pokemon.add(new Pokemon( "Pineco", "Normal: 633 | Boosted: 791", R.drawable.ic_pineco, R.drawable.ic_pineco_stats));
        lstFrag1Pokemon.add(new Pokemon( "Sneasel", "Normal: 1172 | Boosted: 1465", R.drawable.ic_sneasel, R.drawable.ic_sneasel_stats));
        lstFrag1Pokemon.add(new Pokemon( "Magcargo", "Normal: 972 | Boosted: 1215", R.drawable.ic_magcargo, R.drawable.ic_magcargo_stats));
        lstFrag1Pokemon.add(new Pokemon( "Grovyle", "Normal: 956 | Boosted: 1195", R.drawable.ic_grovyle, R.drawable.ic_grovyle_stats));
        lstFrag1Pokemon.add(new Pokemon( "Combusken", "Normal: 944 | Boosted: 1180", R.drawable.ic_combusken, R.drawable.ic_combusken_stats));
        lstFrag1Pokemon.add(new Pokemon( "Marshtomp", "Normal: 1015 | Boosted: 1269", R.drawable.ic_marshtomp, R.drawable.ic_marshtomp_stats));
        lstFrag1Pokemon.add(new Pokemon( "Kirlia", "Normal: 552 | Boosted: 690", R.drawable.ic_kirlia, R.drawable.ic_kirlia_stats));
        lstFrag1Pokemon.add(new Pokemon( "Nosepass", "Normal: 567 | Boosted: 709", R.drawable.ic_nosepass, R.drawable.ic_nosepass_stats));
        lstFrag1Pokemon.add(new Pokemon( "Sableye", "Normal: 843 | Boosted: 1054", R.drawable.ic_sableye, R.drawable.ic_sableye_stats));
        lstFrag1Pokemon.add(new Pokemon( "Mawile", "Normal: 934 | Boosted: 1167", R.drawable.ic_mawile, R.drawable.ic_mawile_stats));
        lstFrag1Pokemon.add(new Pokemon( "Manectric", "Normal: 1337 | Boosted: 1672", R.drawable.ic_manectric, R.drawable.ic_manectric_stats));
        lstFrag1Pokemon.add(new Pokemon( "Roselia", "Normal: 1068 | Boosted: 1335", R.drawable.ic_roselia, R.drawable.ic_roselia_stats));
        lstFrag1Pokemon.add(new Pokemon( "Alolan Exeggutor", "Normal: 1722 | Boosted: 2153", R.drawable.ic_alolan_exeggutor, R.drawable.ic_alolan_exeggutor_stats));
        lstFrag1Pokemon.add(new Pokemon( "Breloom", "Normal: 1502 | Boosted: 1877", R.drawable.ic_breloom, R.drawable.ic_breloom_stats));
        lstFrag1Pokemon.add(new Pokemon( "Monferno", "Normal: 899 | Boosted: 1124", R.drawable.ic_monferno, R.drawable.ic_monferno_stats));
        lstFrag1Pokemon.add(new Pokemon( "Masquerian", "Normal: 1297 | Boosted: 1622", R.drawable.ic_masquerian, R.drawable.ic_ninjask_stats));
        lstFrag1Pokemon.add(new Pokemon( "Combee", "Normal: 282 | Boosted: 353", R.drawable.ic_combee, R.drawable.ic_ninjask_stats));
        lstFrag1Pokemon.add(new Pokemon( "Yamask", "Normal: 561 | Boosted: 701", R.drawable.ic_yamask, R.drawable.ic_yamask_stats));
        lstFrag1Pokemon.add(new Pokemon( "Quilava", "Normal: 944 | Boosted: 1180", R.drawable.ic_quilava, R.drawable.ic_quilava_stats));

    }
}
