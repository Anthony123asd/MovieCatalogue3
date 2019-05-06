package com.latihan.dicoding.moviecatalogue3;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.latihan.dicoding.moviecatalogue3.loader.MovieAsyncTaskLoader;
import com.latihan.dicoding.moviecatalogue3.model.Movie;

import java.util.ArrayList;


/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class MovieFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<Movie>> {

    private MovieAdapter adapter;


    public MovieFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        adapter = new MovieAdapter(getContext());
        adapter.notifyDataSetChanged();
        getLoaderManager().initLoader(0, savedInstanceState, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(adapter);


            /*ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                @Override
                public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                    GoToDetails(context, position);
                }
            });*/
        }
        return view;
    }

    /*private void GoToDetails(Context context, int position){
        Movie movieClicked = new Movie();
        movieClicked.setTitle(movies.get(position).getTitle());
        movieClicked.setDate(movies.get(position).getDate());
        movieClicked.setDescription(movies.get(position).getDescription());
        movieClicked.setPoster(movies.get(position).getPoster());
        Intent moveToDetailIntent = new Intent(context, MovieDetail.class);
        moveToDetailIntent.putExtra(MovieDetail.MOVIE_DETAIL, movieClicked);
        startActivity(moveToDetailIntent);
    }*/


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public Loader<ArrayList<Movie>> onCreateLoader(int id, Bundle args) {
        return new MovieAsyncTaskLoader(getContext(), id);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Movie>> loader, ArrayList<Movie> movies) {
        adapter.setMovies(movies);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Movie>> loader) {
        adapter.setMovies(null);
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
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction();
    }
}
