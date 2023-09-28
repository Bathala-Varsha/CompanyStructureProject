package project;

public class CompanyStructure
{
	public static void main(String[] args)
	{
		TechnicalLead tl = new TechnicalLead("Raja");
		SoftwareEngineer seA = new SoftwareEngineer("Kasey");
		SoftwareEngineer seB = new SoftwareEngineer("Neha");
		SoftwareEngineer seC = new SoftwareEngineer("Gautam");
		tl.addReport(seA);
		seA.checkInCode();
		seA.checkInCode();
		tl.addReport(seB);
		tl.addReport(seC);
		seC.checkInCode();
		seC.checkInCode();
		System.out.println(tl.getTeamStatus());
		TechnicalLead tl2 = new TechnicalLead("Ankit");
		SoftwareEngineer seD = new SoftwareEngineer("Priyanka");
		SoftwareEngineer seE = new SoftwareEngineer("John");
		SoftwareEngineer seF = new SoftwareEngineer("Jordan");
		SoftwareEngineer seG = new SoftwareEngineer("Karishma");
		tl2.addReport(seD);
		tl2.addReport(seE);
		tl2.addReport(seF);
		tl2.addReport(seG);
		seD.checkInCode();
		seF.checkInCode();
		seF.checkInCode();
		seF.checkInCode();
		seF.checkInCode();
		System.out.println(tl2.getTeamStatus());
		BusinessLead bl = new BusinessLead("Vinod");
		Accountant accA = new Accountant("Lakshman");
		Accountant accB = new Accountant("Isha");
		bl.addReport(accA, tl);
		bl.addReport(accB, tl2);
		System.out.println(bl.getTeamStatus());
		System.out.println(seB.toString() + "'s manager is " + seB.getManager().toString());
		System.out.println(seF.toString() + "'s manager is " + seF.getManager().toString());
		System.out.println(accB.toString() + "'s manager is " + accB.getManager().toString());
		System.out.println();
		System.out.println("Testing BusinessLead approvedBonus()");
		System.out.print(seA.getManager() + " is asking for $10,000 bonus for "+seA.getName()+", (the Approval result should be TRUE): ");
		System.out.println(tl.requestBonus(seA, 10000));
		System.out.println("Updated budget is: "+seA.getManager().getAccountantSupport().getBonusBudget()+"\n");
		System.out.print(seF.getManager() + " is asking for $5,000 bonus for "+seF.getName() +", (the Approval result should be TRUE): ");
		System.out.println(tl2.requestBonus(seF, 5000));
		System.out.println("Updated budget is: "+seF.getManager().getAccountantSupport().getBonusBudget()+"\n");
		System.out.print(seF.getManager() + " is asking for $400,000 bonus  for "+seF.getName()+", (the Approval result should be FALSE): ");
		System.out.println(tl2.requestBonus(seF, 400000));
		System.out.println("Updated budget is: "+seF.getManager().getAccountantSupport().getBonusBudget()+"\n");
		System.out.println();
	}

}
