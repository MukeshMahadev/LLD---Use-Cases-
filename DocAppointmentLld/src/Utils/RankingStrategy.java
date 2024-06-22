package Utils;

import models.Appointment;

import java.util.List;

public interface RankingStrategy {
    List<Appointment> rank(List<Appointment> appointments);
}
