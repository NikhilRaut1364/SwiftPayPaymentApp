<%
String id = request.getParameter("id");
int amount = Integer.parseInt(request.getParameter("amount"));
if(id.equals("A1") || id.equals("A2") || id.equals("A3") || id.equals("A4") || id.equals("A5") || id.equals("A6"))
{
	out.println(amount - 100);
}
if(id.equals("B1") || id.equals("B2") || id.equals("B3") || id.equals("B4") || id.equals("B5") || id.equals("B6"))
{
	out.println(amount - 100);
}
if(id.equals("C1") || id.equals("C2") || id.equals("C3") || id.equals("C4") || id.equals("C5") || id.equals("C6"))
{
	out.println(amount - 200);
}
if(id.equals("D1") || id.equals("D2") || id.equals("D3") || id.equals("D4") || id.equals("D5") || id.equals("D6"))
{
	out.println(amount - 200);
}
if(id.equals("E1") || id.equals("E2") || id.equals("E3") || id.equals("E4") || id.equals("E5") || id.equals("E6"))
{
	out.println(amount - 300);
}
if(id.equals("F1") || id.equals("F2") || id.equals("F3") || id.equals("F4") || id.equals("F5") || id.equals("F6"))
{
	out.println(amount - 300);
}
%>