package showcasepager.icechen1.com.showcasepagerfragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowcaseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShowcaseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowcaseFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private ArrayList<Integer> mParam1;

    private OnFragmentInteractionListener mListener;
    private ImagePagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param ids A list of drawable ressources to show
     * @return A new instance of fragment ShowcaseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShowcaseFragment newInstance(ArrayList<Integer> ids) {
        ShowcaseFragment fragment = new ShowcaseFragment();
        Bundle args = new Bundle();
        args.putIntegerArrayList(ARG_PARAM1, ids);
        fragment.setArguments(args);
        return fragment;
    }

    public ShowcaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getIntegerArrayList(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_showcase, container, false);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new ImagePagerAdapter();

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) v.findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    /**
     * A {@link android.support.v4.view.PagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class ImagePagerAdapter extends PagerAdapter {

        public ImagePagerAdapter() {
            super();
        }
        @Override
        public Object instantiateItem(ViewGroup Container, int Position) {
            ImageView Iv = new ImageView(getActivity());
            Iv.setPadding(0, 0, 0, 0);
            Iv.setScaleType(ImageView.ScaleType.FIT_XY);
            Iv.setImageDrawable(getActivity().getResources().getDrawable(mParam1.get(Position)));
            Container.addView(Iv, 0);
            return Iv;
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return mParam1.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(ViewGroup Container, int Position,
                                Object Object) {
            Container.removeView((ImageView) Object);
        }
    }
}
