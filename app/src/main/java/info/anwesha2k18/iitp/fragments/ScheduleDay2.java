package info.anwesha2k18.iitp.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.anwesha2k18.iitp.R;
import info.anwesha2k18.iitp.activities.EventInfoActivity;
import info.anwesha2k18.iitp.adapters.ScheduleRecyclerViewAdapter;
import info.anwesha2k18.iitp.data.EventsData;

public class ScheduleDay2 extends android.support.v4.app.Fragment implements ScheduleRecyclerViewAdapter.ListCardClick {

    RecyclerView recyclerView;
    ScheduleRecyclerViewAdapter scheduleRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_schedule_day2, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_schedule_day2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        Resources resources = getResources();

        scheduleRecyclerView = new ScheduleRecyclerViewAdapter(getContext(),
                this,
                resources.getStringArray(R.array.array_day1_event_header),
                resources.getStringArray(R.array.array_day1_event_text),
                resources.getStringArray(R.array.array_day1_event_time),
                resources.getStringArray(R.array.array_day1_event_dates),
                resources.getStringArray(R.array.array_day1_event_location),
                resources.obtainTypedArray(R.array.array_day1_event_image));
        recyclerView.setAdapter(scheduleRecyclerView);
        return rootView;
    }

    @Override
    public void onListClick(EventsData eventsData, View view) throws ClassNotFoundException {
        Intent intentNew = new Intent(getContext(), Class.forName("info.anwesha2k18.iitp.activities.EventInfoActivity"));
        intentNew.putExtra(EventInfoActivity.EXTRA_HEADER, eventsData.getHeader());
        intentNew.putExtra(EventInfoActivity.EXTRA_LONG_DESCRIPTION, eventsData.getText());
        intentNew.putExtra(EventInfoActivity.EXTRA_TIME, eventsData.getDateTime());
        intentNew.putExtra(EventInfoActivity.EXTRA_VENUE, eventsData.getVenue());
        intentNew.putExtra(EventInfoActivity.EXTRA_IMAGE_ID, eventsData.getImageId());
        startActivity(intentNew);
    }
}
