package com.support.android.designlibdemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xlf.nrl.NsRefreshLayout;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TestReflshListviewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * \

 * create an instance of this fragment.
 */
public class TestReflshListviewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private boolean loadMoreEnable = true;
    private NsRefreshLayout refreshLayout;
    private RecyclerView rvTest;
    private OnFragmentInteractionListener mListener;

    public TestReflshListviewFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test_reflsh_listview, container, false);
       initView(view);
        return view;
    }

    private void initView(View view) {


        refreshLayout= (NsRefreshLayout) view.findViewById(R.id.nrl_test);

        refreshLayout.setRefreshLayoutListener(new NsRefreshLayout.NsRefreshLayoutListener() {
            @Override
            public void onRefresh() {



                refreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishPullRefresh();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {



                refreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishPullLoad();
                    }
                }, 2000);

            }
        });

         rvTest= (RecyclerView) view.findViewById(R.id.rv_test);
        DividerLine dividerLine = new DividerLine(DividerLine.VERTICAL);
        dividerLine.setSize(1);
        dividerLine.setColor(0xFFDDDDDD);
        rvTest.addItemDecoration(dividerLine);
         rvTest.setAdapter( new TestRecyclerAdapter(getActivity()));






    }

    public class TestRecyclerAdapter extends RecyclerView.Adapter<TestRecyclerAdapter.ViewHolder> {
        private LayoutInflater mInflater;
        private String[] mTitles = null;

        public TestRecyclerAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
            this.mTitles = new String[20];
            for (int i = 0; i < 20; i++) {
                int index = i + 1;
                mTitles[i] = "item" + index;
            }
        }

        /**
         * item显示类型
         *
         * @param parent
         * @param viewType
         * @return
         */
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.item_recycler_layout, parent, false);
        //    view.setBackgroundColor(Color.RED);
            ViewHolder viewHolder = new ViewHolder(view);

            return viewHolder;
        }

        /**
         * 数据的绑定显示
         *
         * @param holder
         * @param position
         */
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.item_tv.setText(mTitles[position]);
        }

        @Override
        public int getItemCount() {
            return mTitles.length;
        }

        //自定义的ViewHolder，持有每个Item的的所有界面元素
        public  class ViewHolder extends RecyclerView.ViewHolder {
            public TextView item_tv;

            public ViewHolder(View view) {
                super(view);
                item_tv = (TextView) view.findViewById(R.id.item_tv);
            }
        }
    }
        // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

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
        void onFragmentInteraction(Uri uri);
    }
}
