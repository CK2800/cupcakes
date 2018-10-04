/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhc.presentation;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jhc.data.LineItemDTO;
import jhc.data.ProductDTO;
import jhc.data.UserDTO;
import jhc.logic.OrderDAO;
import jhc.logic.ProductDAO;
import jhc.logic.UserDAO;

/**
 * The FrontController is responsible for distributing HTTP requests 
 * based on the origin parameter of the request.
 * The origin parameter can be included in the request as a query string 
 * parameter (GET) or a parameter within a HTML form element (POST).
 * @author Claus
 * 
 */
public class FrontController extends HttpServlet 
{
    /**
     * An invoice is requested.
     */
    public static final String INVOICE = "invoiceDetails"; 
    /**
     * Add items to the basket.
     */
    public static final String ADD_TO_BASKET = "addToBasket";
    /**
     * An order is to be created.
     */
    public static final String CREATE_ORDER = "createOrder";
    /**
     * A user is to be created.
     */
    public static final String CREATE_USER = "createUser";
    /**
     * The user wants to proceed to checkout.
     */
    public static final String CHECKOUT = "checkout";
    /**
     * A user wants to log in with provided credentials.
     */
    public static final String LOGIN = "login";
    /**
     * A user wants to log out.
     */
    public static final String LOGOUT = "logout";
    /**
     * Specifying the POST method.
     */
    public static final String POST = "post";
    /**
     * Specifying the GET method.
     */
    public static final String GET = "get";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String origin = request.getParameter("origin"); // Must match constants.
        String method = request.getMethod().toLowerCase();
        if (origin != null) 
        {
            switch (origin) 
            {
                case CREATE_ORDER:
                {
                    // Get session user and cart.
                    ArrayList<LineItemDTO> lineItems = (ArrayList<LineItemDTO>)request.getSession().getAttribute("lineItems");
                    UserDTO user = (UserDTO)request.getSession().getAttribute("userDTO");
                    if (user != null && lineItems != null && !lineItems.isEmpty())
                    {
                        if (OrderDAO.createOrder(user, lineItems))
                        {
                            // remove lineitems from session
                            request.getSession().setAttribute("lineItems", null);
                            request.getRequestDispatcher("customerspage/orders.jsp").forward(request, response);                            
                        }
                        else
                        {
                            // order not created, return to checkout.
                            request.getRequestDispatcher("Cart.jsp").forward(request, response);
                        }
                    }
                }
                break;
                case ADD_TO_BASKET:
                {
                    
                    // find selected bottom and topping as well as qty.
                    int bottomId = Integer.parseInt(request.getParameter("bottoms"));                    
                    int toppingId = Integer.parseInt(request.getParameter("toppings"));
                    int qty = Integer.parseInt(request.getParameter("qty"));
                    
                    ProductDTO bottom = ProductDAO.getSingleProduct(bottomId);
                    ProductDTO topping = ProductDAO.getSingleProduct(toppingId);
                    
                    HttpSession session = request.getSession();
                    
                    ArrayList<LineItemDTO> lineItems = (ArrayList<LineItemDTO>)session.getAttribute("lineItems");
                    if (lineItems == null)
                        lineItems = new ArrayList<LineItemDTO>();
                    
                    // See if same product has already been ordered in this session.
                    //for(LineItemDTO lineItem)
                    
                    lineItems.add(new LineItemDTO(0, bottomId, bottom.getName(), qty, bottom.getPrice()));
                    lineItems.add(new LineItemDTO(0, toppingId, topping.getName(), qty, topping.getPrice()));
                    
                    session.setAttribute("lineItems", lineItems);
                    
                    request.getRequestDispatcher("Cart.jsp").forward(request, response);
                    
                }
                break;
                case CHECKOUT:
                {
                    request.getRequestDispatcher("Cart.jsp").forward(request, response);
                }
                break;
                case CREATE_USER:
                {
                    request.getRequestDispatcher("createUser.jsp").forward(request, response);
                }
                break;
                case INVOICE: {
                    request.getRequestDispatcher("customerspage/invoiceDetails.jsp").forward(request, response);
                }
                break;

                case CREATE_RECIPE: {
                    // Check for logged in user.
                    if (userIsAuthenticated(request))     
                    {
                        if (method.equals(GET))
                            request.getRequestDispatcher("createRecipe.jsp").forward(request, response);
                        else // method is POST, user creates recipe now.
                        {
                            if (ProductDAO.createRecipe(Integer.parseInt(request.getParameter("userId")), request.getParameter("headline"), request.getParameter("instructions"), request.getParameter("ingredients")))
                            {
                                // Recipe was created, forward request to index.jsp to reflect changes.
                                response.sendRedirect("index.jsp");
                                //request.getRequestDispatcher("index.jsp").sendRedirect(request, response);                                
                            }
                            else // Show create recipe form again.
                            {          
                                request.setAttribute("errorMessage", "Recipe creation failed, please try again.");
                                request.getRequestDispatcher("createRecipe.jsp").forward(request, response);
                            }
                        }
                    }
                    else // No user logged in, forward to login page.
                    {                        
                        invalidateSession(request);
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                        
                }
                break;

                case EDIT_RECIPE: {
                    // Check for logged in user.
                    if(userIsAuthenticated(request))
                        request.getRequestDispatcher("editRecipe.jsp").forward(request, response);
                    else // No user logged in, forward to login page.
                    {
                        invalidateSession(request);                    
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                }
                break;
                case LOGOUT:
                {
                    // Invalidate the session.
                    invalidateSession(request);
                    // forward to index.jsp.
                    request.getRequestDispatcher("index.jsp").forward(request, response);                    
                }
                break;
                case LOGIN: {
                    if (method.equals(GET)) 
                    {
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } 
                    else // method is POST, user tries to log in now.
                    {
                        invalidateSession(request);
                        if (loginUser(request, request.getParameter("name"), request.getParameter("password")))
                        {
                            // after login, show index.jsp.
                            response.sendRedirect("index.jsp");
                            //request.getRequestDispatcher("index.jsp").forward(request, response);
                        }
                        else
                        {
                            // no login, show login page.
                            request.setAttribute("errorMessage", "Login failed, resubmit credentials and try again.");
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                        }
                    }
                }
                break;

                default: {
                    // no forwarding, will be done when control leaves switch. 
                }
                break;
            }
        }
        else // If no origin, redirect to index.html
            request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**
     * Helper method to determine if session has a logged in user.
     * @param request Current HttpServletRequest
     * @return true if session has a UserDTO object, false otherwise.
     */
    public static boolean userIsAuthenticated(HttpServletRequest request)
    {
        return request.getSession().getAttribute("userDTO") != null;
    }
    /**
     * Static helper method to log in user and store UserDTO in session.
     * @param request Current HttpServletRequest
     * @param name Username of the user logging in.
     * @param password Password of the user logging in.
     * @return boolean Returns true if user is logged in, false otherwise.
     */
    public static boolean loginUser(HttpServletRequest request, String name, String password) 
    {        
        // sanitize.
        name = name.trim();
        password = password.trim(); // sha og hash kommer senere...
            
        try 
        {
            UserDTO userDTO = UserDAO.getUser(name);
            if (userDTO != null && userDTO.getPassword().equals(password)) 
            {
                HttpSession session = request.getSession();
                // Store userDTO in session - possibly bad practice due to password.
                session.setAttribute("userDTO", userDTO);
                return true;
            }

        } catch (Exception e) {
            System.out.println("FrontController.LoginUser(String, String): " + e.getMessage());
        }
        return false;
    }
    
    /**
     * Invalidates a session.
     * @param request Current HttpServletRequest.
     */
    public static void invalidateSession(HttpServletRequest request)
    {
         // Invalidate old session if one exists.
        HttpSession oldSession = request.getSession(false);
        if (oldSession != null)
            oldSession.invalidate();
    }    
}
