package BLL;

import Models.Priority.*;

import java.util.List;

import DAL.PrioritiesDAL;

public class PriorityManager {
	public static List<PrioritiesData> addPriority(PrioritiesData Priority) {
		return PrioritiesDAL.addPriority(Priority);
	}
	public static boolean deletePriority(PrioritiesData Priority) {
		return PrioritiesDAL.deleteField(Priority);
	}

}
