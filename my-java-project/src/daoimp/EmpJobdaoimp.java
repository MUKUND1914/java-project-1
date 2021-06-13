package daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.Jdbconnection;
import dao.IEmpJobDao;
import model.Empjob;

public class EmpJobdaoimp implements IEmpJobDao {
    Connection con=null;
	private Empjob empj;
    
     public EmpJobdaoimp() throws ClassNotFoundException, SQLException {
	   con=Jdbconnection.getDBconnection();
	}
	@Override
	public List<Empjob> getAllEmpJob() {
		List<Empjob>allemp=new ArrayList<Empjob>();
		try
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select*from empjob");
			while(rs.next())
			{
				empj = null;
				empj.setEJId(rs.getInt(1));
				empj.setEmpId(rs.getInt(2));
				empj.setJobId(rs.getInt(3));
				empj.setRecruited(rs.getString(4));
				allemp.add(empj);
			}
		}
		
		catch(SQLException q)
		{
			q.printStackTrace();
		}
		
		
		return allemp;
	}

	@Override
	public void addEmpJob(Empjob emj) 
	{
		try
		{
			PreparedStatement pre=con.prepareStatement("insert into empjob(employeeid,jobid,recruited) values(?,?,?) ");
			pre.setInt(1, emj.getEmpId());
			pre.setInt(2,emj.getJobId() );
			pre.setString(3,emj.getRecruited());
			int i=pre.executeUpdate();
			JFrame a =new JFrame();
			if(i==1)
			{
				JOptionPane.showMessageDialog(a,"we have recived your application");
			}
			else
			{
				JOptionPane.showMessageDialog(a,"SomeThing went Wrong");
			}
           	
		}
		catch(SQLException g)
		{
			g.printStackTrace();
		}
		
	}

	@Override
	public Empjob getEmpJobById(int i) {
		Empjob e=new Empjob();
		try
		{
		PreparedStatement yt=con.prepareStatement("select *from empjob where empid=?");
		yt.setInt(1, i);
		ResultSet rs=yt.executeQuery();
		if(rs!=null)
		{
		 while(rs.next())
		  {
			 e.setEJId(rs.getInt(1));
			 e.setEmpId(rs.getInt(2));
			 e.setJobId(rs.getInt(3));
			 e.setRecruited(rs.getString(4));
		  }
		}
		
		}
		catch(Exception l)
		{
			l.printStackTrace();
		}
		return e;
	}

	@Override
	public void updateEmpJob(Empjob emj) {
		try
		{
			PreparedStatement u=con.prepareStatement("upadte empjob set recruited=? where ejid=?");
			u.setString(1,emj.getRecruited());
			u.setInt(2,emj.getEJId());
			int i=u.executeUpdate();
			JFrame x=new JFrame();
			if(i==1)
			{
				JOptionPane.showMessageDialog(x,"Updated");
			}
			else
			{
				JOptionPane.showMessageDialog(x,"Update falied");
			}
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	

	}

	@Override
	public void deleteEmpJob(int id) {
	    try
	    {
	    	PreparedStatement r=con.prepareStatement("delect from empjob where emmployeeid=?");
	    	r.setInt(1, id);
	    	int i=r.executeUpdate();
	    	JFrame m=new JFrame();
	    	if(i==1)
	    	{
	    		JOptionPane.showMessageDialog(m," deleted successfully");
	    	}
	    	else
	    	{
	    		JOptionPane.showMessageDialog(m, "Not deleted");
	    		
	    	}
	    }
	    catch(Exception j)
	    {
	    	j.printStackTrace();
	    }

	}

}
