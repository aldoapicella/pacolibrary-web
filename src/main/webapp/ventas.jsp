<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head> 
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Historial de Ventas</title>
    <link rel="stylesheet" href="../css/HistorialVentas.css">
</head>
<body>
    <main>
        <section id="Container-consulta">
            <div class="titulo-suc1">
                <h1>Historial de Ventas</h1>
            </div>
            <form action="InvoiceServlet" method="get">
                <div class="Consulta-sucursal">
                    <div>
                        <label for="codfac">Numero de Factura: </label>
                        <input type="text" id="codfac" name="codfac" title="Escriba el codigo de factura" placeholder="00000000"><br>
                    </div>
                    <div>
                        <label for="Sucursal">Sucursal:</label>
                        <select name="Sucursal" id="Sucursal" size="1" title="Seleccione una sucursal">
                            <option value="" selected>Todas</option>
                            <option value="Panamá">Panamá</option>
                            <option value="Arraiján">Arraiján</option>
                            <option value="Chiriquí">Chiriquí</option>
                        </select>
                    </div>
                    <div> 
                        <input type="submit" value="Enviar Consulta" id="boton-enviar"><br>
                    </div>
                </div>
            </form>
        </section>
        <section class="Container-inventario">
            <div class="Inventario1">
                <table>
                    <tr>
                        <th>Numero de Factura</th>
                        <th>Sucursal</th>
                        <th>Hora</th>
                        <th>Fecha</th>
                        <th>Costo Total</th>
                        <th></th>
                    </tr>
                    <c:forEach var="invoice" items="${invoices}">
                        <tr id="fila-data">
                            <td>${invoice.invoiceNumber}</td>
                            <td>${invoice.branch}</td>
                            <td>${invoice.time}</td>
                            <td>${invoice.date}</td>
                            <td>$${invoice.totalCost}</td>
                            <td>
                                <a href="VerDetalles.html?invoiceNumber=${invoice.invoiceNumber}" class="btn-ver-detalles">Ver detalles</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
    </main>
</body>
</html>