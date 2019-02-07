package pru05;

import java.util.Date;

public class Empleado {
	
		//VARIABLES
	
        int emp_no;
       	Date birth_date;
        String first_name;
        String last_name;
        
        //SETTERS
        
        public void setEmp_no(int emp_no) {
			this.emp_no = emp_no;
		}
		public void setBirth_date(Date birth_date) {
			this.birth_date = birth_date;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		
		//GETTERS
		
		public int getEmp_no() {
			return emp_no;
		}
		public Date getBirth_date() {
			return birth_date;
		}
		public String getFirst_name() {
			return first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		
		
	
}
