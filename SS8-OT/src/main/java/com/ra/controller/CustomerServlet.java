package com.ra.controller;

import com.ra.model.Customer;
import com.ra.service.CustomerServiceIMPL;
import com.ra.service.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                formCreateCustomer(req, resp);
                break;
            case "edit":
                formEditCustomer(req, resp);
                break;
            case "delete":
                formDeleteCustomer(req, resp);
                break;
            case "search":
                formSearchCustomer(req, resp);
                break;
            default:
                formshowListCustomer(req, resp);
                break;
        }
    }

    private void formSearchCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("search");
        List<Customer> listSearch = customerService.finByName(name);
        req.setAttribute("customers", listSearch);
        req.setAttribute("searchName", name);
        req.getRequestDispatcher("customer/list.jsp").forward(req, resp);
    }

    private void formDeleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idDelete = Integer.parseInt(req.getParameter("id"));
        customerService.remove(idDelete);
        formshowListCustomer(req, resp);
    }

    private void formEditCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idEdit = Integer.parseInt(req.getParameter("id"));
        Customer customerEdit = customerService.findById(idEdit);
        // mang du lieu di
        req.setAttribute("customer", customerEdit);
        req.getRequestDispatcher("customer/edit.jsp").forward(req, resp);
    }

    private void formCreateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("customer/create.jsp").forward(req, resp);
    }

    public void formshowListCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customerList = customerService.finAll();
        req.setAttribute("customers", customerList);
        req.getRequestDispatcher("customer/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                actionCreateCustomer(req, resp);
            case "edit":
                actionEditCustomer(req, resp);
                break;
        }
    }

    private void actionEditCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idEdit = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        Customer customerEdit = customerService.findById(idEdit);
        customerEdit.setName(name);
        customerEdit.setEmail(email);
        customerEdit.setAddress(address);

        customerService.save(customerEdit);
        formshowListCustomer(req, resp);
    }

    private void actionCreateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = customerService.getNewId();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer);
        formshowListCustomer(req, resp);
    }
}
