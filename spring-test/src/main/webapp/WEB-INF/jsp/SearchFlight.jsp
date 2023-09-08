<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
     <form action="flightBooking" method="post">
        <table width="70%" align="center"   bgcolor="green">
           <tr>
             <th>Source</th>
             <td><input type="text" name="src" placeholder="Enter Source"></td>
           </tr>
           <tr>
             <th>Destination</th>
             <td><input type="text" name="dest" placeholder="Enter Source"></td>
           </tr>
           <tr>
             <td><input type="submit"  value="Search"></td>
             <td><input type="reset"   value="Cancel"></td>
           </tr>
        </table>
     </form>
</body>
</html>