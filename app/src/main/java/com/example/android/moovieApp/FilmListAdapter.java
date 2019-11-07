package com.example.android.moovieApp;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.moovieApp.data.MoovieListContract;

import java.util.Date;


public class FilmListAdapter extends RecyclerView.Adapter<FilmListAdapter.FilmViewHolder> {

    // Holds on to the cursor to display the filmlist
    private Cursor mCursor;
    private Context mContext;

    /**
     * Constructor using the context and the db cursor
     * @param context the calling context/activity
     * @param cursor the db cursor with filmlist data to display
     */
    public FilmListAdapter(Context context, Cursor cursor) {
        this.mContext = context;
        this.mCursor = cursor;
    }

    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get the RecyclerView item layout
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.film_list_item, parent, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilmViewHolder holder, int position) {
        // Move the mCursor to the position of the item to be displayed
        if (!mCursor.moveToPosition(position))
            return; // bail if returned null

        // Update the view holder with the information needed to display
        String titreFilm = mCursor.getString(mCursor.getColumnIndex(MoovieListContract.MoovielistEntry.COLUMN_TITRE_FILM));
        String date = mCursor.getString(mCursor.getColumnIndex(MoovieListContract.MoovielistEntry.COLUMN_DATE_FILM));
        int noteMusique = mCursor.getInt(mCursor.getColumnIndex(MoovieListContract.MoovielistEntry.COLUMN_NOTE_MUSIQUE));
        int noteScenario = mCursor.getInt(mCursor.getColumnIndex(MoovieListContract.MoovielistEntry.COLUMN_NOTE_SCENARIO));
        int noteRealisation = mCursor.getInt(mCursor.getColumnIndex(MoovieListContract.MoovielistEntry.COLUMN_NOTE_REALISATION));
        String Description = mCursor.getString(mCursor.getColumnIndex(MoovieListContract.MoovielistEntry.COLUMN_DESCRIPTION));
        int heure = mCursor.getInt(mCursor.getColumnIndex(MoovieListContract.MoovielistEntry.COLUMN_HEURE_FILM));


        holder.filmTextView.setText(titreFilm);
        holder.dateTextView.setText(date);
        holder.heureTextView.setText(heure);
        holder.noteMusiqueTextView.setText(noteMusique);
        holder.noteRealisationTextView.setText(noteRealisation);
        holder.noteScenarioTextView.setText(noteScenario);
        holder.descriptionTextView.setText(Description);
    }


    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    // COMPLETED (15) Create a new function called swapCursor that takes the new cursor and returns void
    /**
     * Swaps the Cursor currently held in the adapter with a new one
     * and triggers a UI refresh
     *
     * @param newCursor the new cursor that will replace the existing one
     */
    public void swapCursor(Cursor newCursor) {
        // COMPLETED (16) Inside, check if the current cursor is not null, and close it if so
        // Always close the previous mCursor first
        if (mCursor != null) mCursor.close();
        // COMPLETED (17) Update the local mCursor to be equal to  newCursor
        mCursor = newCursor;
        // COMPLETED (18) Check if the newCursor is not null, and call this.notifyDataSetChanged() if so
        if (newCursor != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }

    /**
     * Inner class to hold the views needed to display a single item in the recycler-view
     */
    class FilmViewHolder extends RecyclerView.ViewHolder {

        // Will display the film name
        TextView filmTextView;
        // Will display the date
        TextView dateTextView;
        // Will display heure
        TextView heureTextView;
        // Will display note musique
        TextView noteMusiqueTextView;
        // Will display note scenario
        TextView noteScenarioTextView;
        // Will display note realisation
        TextView noteRealisationTextView;
        // Will display description
        TextView descriptionTextView;

        /**
         * Constructor for our ViewHolder. Within this constructor, we get a reference to our
         * TextViews
         *
         * @param itemView The View that you inflated in
         *                 {@link FilmListAdapter#onCreateViewHolder(ViewGroup, int)}
         */
        public FilmViewHolder(View itemView) {
            super(itemView);
            filmTextView = (TextView) itemView.findViewById(R.id.film_text_view);
            noteScenarioTextView = (TextView) itemView.findViewById(R.id.note_text_view);
        }

    }
}