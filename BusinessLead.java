package project;
import java.util.ArrayList;
public class BusinessLead extends BusinessEmployee 
{
	public ArrayList<Accountant> team;

	public BusinessLead(String name)
	{
		//Should create a new BusinessLead that is a Manager.
		// The BusinessLead's base salary should be twice that of an Accountant.
		// They should start with a head count of 10.
		super(name);
		this.baseSalary=getBaseSalary()*2;
		this.headcount=10;
		this.team=new ArrayList<Accountant>();
	}

	public boolean hasHeadCount()
	{
		//Should return true if the number of direct reports this manager has is less than their headcount.
		if(this.team.size()<this.headcount)
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}

	public boolean addReport(Accountant e, TechnicalLead supportTeam)	
	{
		if (hasHeadCount())
		{
			team.add(e);
			e.setManager(this);
			this.bonusBudget+=e.baseSalary*1.1;
			e.supportTeam(supportTeam);
			supportTeam.accountantSupport=e;
			return true;
		} 
		else 
		{
			return false;
		}
	}
	public boolean requestBonus(Employee e, double bonus)
	{
		//Should check if the bonus amount requested would fit in current BusinessLead's budget.
		// If it is, that employee should get that bonus, the BusinessLeader's budget should be deducted and true should be returned. False should be returned otherwise
		if (bonus<=getBonusBudget())
		{
			this.bonusBudget-=bonus;
			e.bonusBudget+=bonus;
			return true;
		} 
		else 
		{
			return false;
		}
	}


	public boolean approveBonus(Employee e, double bonus)
	{
		//This function should look through the Accountants the BusinessLead manages,
		// and if any of them are supporting a the TechnicalLead that is the manager of the Employee passed in then the Accountant's budget should be consulted to see if the bonus could be afforded.
		// If the team can afford the bonus it should be rewarded and true returned, false otherwise

		for (int i=0;i<team.size();i++)
		{
			if((team.get(i).getTeamSupported()).equals(e.manager) && team.get(i).canApproveBonus(bonus)) 
			{
				e.bonus += bonus;
				team.get(i).bonusBudget -= bonus;
				return true;
			}
		}
		return  false;
	}

	public String getTeamStatus()
	{

		if (team.size()==0)
		{
			return this.employeeStatus()+ " and no direct reports yet";
		} 
		else
		{
			String teamStatus="";
			for (int i=0;i<team.size();i++)
			{
				teamStatus+=("    "+team.get(i).employeeStatus()+"\n");
			}
			return this.employeeStatus()+" and is managing: \n"+teamStatus;

		}
	}

}
