package com.mgnregs.dto;

public class AllEmp {
	Employee e;
	ocupation oc;
	workerslog wl;
	public AllEmp() { }
	public AllEmp(Employee e, ocupation oc, workerslog wl) {
		this.e = e;
		this.oc = oc;
		this.wl = wl;
	}
	
	@Override
	public String toString() {
		return "emp id : "+e.getEmp_id()+" , emp_name : "+e.getEmp_name()+" , emp_ocupation : "+oc.getOcupation_name()+" , emp_salary : "+oc.getSalary_wage()+" , start_date : "+wl.getStart_date()+" , curr/relv_date : "+wl.getReleving_date()+" , days : "+wl.getDays()+"\n";
	}
	
}
