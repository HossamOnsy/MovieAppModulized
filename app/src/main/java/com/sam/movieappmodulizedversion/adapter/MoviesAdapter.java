package com.sam.movieappmodulizedversion.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sam.movieappmodulizedversion.R;
import com.sam.movieappmodulizedversion.models.MovieList;
import com.sam.movieappmodulizedversion.models.MovieModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    MovieList movieModelArrayList;
    Activity activity;

    public MoviesAdapter(MovieList movieModelArrayList, Activity activity) {
        this.movieModelArrayList = movieModelArrayList;
        this.activity = activity;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.movie_list_item, parent, false);

        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MovieModel movieModel = movieModelArrayList.getResults().get(position);

//        holder.movie_iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentTransaction fragmentTransaction = activity.getFragmentManager().beginTransaction();
//                Fragment fragment = new MovieDetailsFragment();
//                Bundle bundle = new Bundle();
//                bundle.putParcelable("MovieModel", movieModel);
//                fragment.setArguments(bundle);
//                fragmentTransaction.add(R.id.fragment_container, fragment, activity.getString(R.string.movie_detail_fragment_tag));
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//
//            }
//        });
        String picassoURL = "https://image.tmdb.org/t/p/w185" + movieModel.getPosterPath();
        //TODO URL of That Movie
        Picasso.with(activity).load(picassoURL).placeholder(R.drawable.loading)
                .error(R.drawable.error).fit().into(holder.movie_iv);

    }

    @Override
    public int getItemCount() {
        if (movieModelArrayList.getResults()!=null)
        return movieModelArrayList.getResults().size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView movie_iv;

        public ViewHolder(View itemView) {
            super(itemView);
            movie_iv = itemView.findViewById(R.id.movie_iv);


        }
    }
}
