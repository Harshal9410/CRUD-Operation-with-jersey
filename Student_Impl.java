package com.spms.ws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.spms.ws.dbconnection.DbUtility;
import com.spms.ws.pojo.Student;

public class Student_Impl implements Stud_Int {

	Connection con = DbUtility.getcon();;
	int flag;
	PreparedStatement pstat;

	@Override
	public boolean add_stud(Student s) {
		
		String sql = "INSERT INTO Student(student_name, student_dob, student_doj) VALUES (?,?,?)";
		try {
			java.sql.Date birthDate = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(s.getStudent_dob()).getTime());
			java.sql.Date joiningDate = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(s.getStudent_doj()).getTime());
			pstat = con.prepareStatement(sql);
			pstat.setString(1, s.getStudent_name());
			pstat.setDate(2, birthDate);
			pstat.setDate(3, joiningDate);
			flag = pstat.executeUpdate();
			if (flag > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean updateStudent(Student s) {
		boolean status = false;
		try {
			Connection con = DbUtility.getcon();
			java.sql.Date birthDate = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(s.getStudent_dob()).getTime());
			java.sql.Date joiningDate = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(s.getStudent_doj()).getTime());
			String query="update student set student_name=?,student_dob=?,student_doj=? where student_no=?";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println(query);
			ps.setString(1, s.getStudent_name());
			ps.setDate(2, birthDate);
			ps.setDate(3, joiningDate);
			ps.setInt(4, s.getStudent_no());
			int insertedRow = ps.executeUpdate();
			if (insertedRow > 0)
				status = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public boolean deleteStudent(Integer studentId) {
		// TODO Auto-generated method stub
	      boolean status=false;  
	        try{  
	        	Connection con = DbUtility.getcon();  
	            PreparedStatement ps=con.prepareStatement("delete from student where student_no=?");  
	            ps.setInt(1, studentId);
				int insertedRow = ps.executeUpdate();
				if (insertedRow > 0)
					status = true;
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try {
					if (con != null)
						con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return status;
		}


	@Override
	public List<Student> getStudents() {
		List<Student> list=new ArrayList<Student>();  
        
        try{  
            Connection con=DbUtility.getcon();  
            PreparedStatement ps=con.prepareStatement("select * from student");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Student s=new Student();  
                s.setStudent_no((rs.getInt(1)));  
                s.setStudent_name(rs.getString(2));  
                s.setStudent_dob(rs.getDate(3).toString());  
                s.setStudent_doj(rs.getDate(4).toString());  
                list.add(s);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();} 
        finally {
        	try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return list;  
	}

}
