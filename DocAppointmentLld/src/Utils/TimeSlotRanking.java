package Utils;

import models.Appointment;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TimeSlotRanking implements RankingStrategy{
    @Override
    public List<Appointment> rank(List<Appointment> appointments) {
        return appointments.stream().sorted(Comparator.comparing(a -> a.getTimeslot().getStart())).collect(Collectors.toList());
    }
}
