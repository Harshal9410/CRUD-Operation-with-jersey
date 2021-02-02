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
import com.spms.ws.pojo.Project;
import com.spms.ws.pojo.Student;

public class Project_Impl implements Project_Int {

	Connection con;
	int flag;
	PreparedStatement pstat;

	@Override
	public boolean add_Project(Project p) {
		con = DbUtility.getcon();
		String sql = "INSERT INTO Project(project_name, project_dur, project_platform) VALUES (?,?,?)";
		try {
			pstat = con.prepareStatement(sql);
			pstat.setString(1, p.getPrj_name());
			pstat.setString(2, p.getPrj_dur());
			pstat.setString(3, p.getPrj_platform());
			flag = pstat.executeUpdate();
			if (flag > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
	public boolean updateProject(Project p) {

		boolean status = false;
		try {
			Connection con = DbUtility.getcon();

			String query = "update project set project_name=?,project_dur=?,project_platform=? where project_no=?";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println(query);
			pstat.setString(1, p.getPrj_name());
			pstat.setString(2, p.getPrj_dur());
			pstat.setString(3, p.getPrj_platform());
			ps.setInt(4, p.getProject_no());
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

		return false;
	}

	@Override
	public boolean deleteProject(Integer projectId) {

		boolean status = false;
		try {
			Connection con = DbUtility.getcon();
			PreparedStatement ps = con.prepareStatement("delete from project where project_no=?");
			ps.setInt(1, projectId);
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

		return false;
	}

	@Override
	public List<Project> getProjectp() {
		
	List<Project> list=new ArrayList<Project>();  
        
        try{  
            Connection con=DbUtility.getcon();  
            PreparedStatement ps=con.prepareStatement("select * from project");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Project p=new Project();  
                p.setProject_no((rs.getInt(1)));  
                p.setPrj_name(rs.getString(2));  
                p.setPrj_dur(rs.getDate(3).toString());  
                p.setPrj_platform(rs.getDate(4).toString());  
                list.add(p);  
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