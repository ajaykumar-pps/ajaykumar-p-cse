<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>finance</title>
    <link rel="stylesheet" href="style.css">
    
    <style>
    /* Reset & Base */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: Arial, sans-serif;
  line-height: 1.6;
  opacity: 0;
  animation: pageFade 1s ease forwards;
  background-color: #ffffff;
}

/* Page Load Animation */
@keyframes pageFade {
  to {
    opacity: 1;
  }
}

/* Navigation */
nav {
  background-color: #222;
  color: white;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 15px 30px;
  flex-wrap: wrap;
}

.logo {
  font-size: 24px;
  font-weight: bold;
  animation: slideIn 1s ease forwards;
}

@keyframes slideIn {
  from {
    transform: translateX(-100px);
    opacity: 0;
  }
  to {
    transform: translateX(0);
    opacity: 1;
  }
}

nav ul {
  display: flex;
  list-style: none;
  gap: 20px;
}

nav ul li a {
  color: white;
  text-decoration: none;
  font-size: 16px;
  padding: 6px 10px;
  transition: all 0.3s ease;
}

nav ul li a:hover {
  transform: scale(1.05);
  background-color: #444;
  border-radius: 5px;
}

/* Home Section */
.home-container {
  background: linear-gradient(to right, #0077b6, #00b4d8);
  color: white;
  padding: 100px 20px;
  text-align: center;
}

.home-container h1 {
  font-size: 48px;
  margin-bottom: 20px;
  animation: fadeUp 1s ease forwards;
}

.home-container p {
  font-size: 20px;
  margin-bottom: 30px;
  animation: fadeUp 1.2s ease forwards;
}

.home-container button {
  padding: 12px 24px;
  font-size: 16px;
  background-color: white;
  color: #0077b6;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: 0.3s ease;
  animation: fadeUp 1.4s ease forwards;
}

.home-container button:hover {
  transform: scale(1.1);
  background-color: #f1f1f1;
}

/* About Section */
.about-section {
  background-color: #f8f8f8;
  padding: 60px 20px;
  text-align: center;
}

.about-container {
  max-width: 800px;
  margin: auto;
}

.about-container h2 {
  font-size: 36px;
  margin-bottom: 20px;
  animation: fadeUp 0.5s ease forwards;
}

.about-container p {
  font-size: 18px;
  color: #555;
  margin-bottom: 15px;
  animation: fadeUp 0.7s ease forwards;
}

/* Services Section */
.services-section {
  background-color: #fff;
  padding: 60px 20px;
  text-align: center;
}

.services-container h2 {
  font-size: 36px;
  margin-bottom: 40px;
  animation: fadeUp 0.5s ease forwards;
}

.services-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 30px;
  max-width: 1100px;
  margin: auto;
}

.service-card {
  background-color: #f4f4f4;
  padding: 25px;
  border-radius: 10px;
  box-shadow: 0 4px 10px rgba(0,0,0,0.05);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  opacity: 0;
  transform: translateY(20px);
  animation: fadeUp 1s forwards;
}

.service-card:hover {
  transform: translateY(-5px);
}

.service-card h3 {
  font-size: 22px;
  margin-bottom: 10px;
}

.service-card p {
  font-size: 16px;
  color: #555;
}

/* Contact Section */
.contact-section {
  background-color: #f9f9f9;
  padding: 60px 20px;
}

.contact-container {
  max-width: 1100px;
  margin: auto;
  text-align: center;
}

.contact-container h2 {
  font-size: 36px;
  margin-bottom: 10px;
  animation: fadeUp 0.5s ease forwards;
}

.contact-intro {
  font-size: 18px;
  color: #666;
  margin-bottom: 40px;
  animation: fadeUp 0.7s ease forwards;
}

.contact-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 40px;
  text-align: left;
}

.contact-info h3 {
  font-size: 22px;
  margin-bottom: 10px;
}

.contact-info p {
  font-size: 16px;
  color: #555;
}

.contact-form {
  display: flex;
  flex-direction: column;
  gap: 15px;
}

.contact-form input,
.contact-form textarea {
  padding: 12px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 6px;
  transition: 0.3s;
}

.contact-form input:focus,
.contact-form textarea:focus {
  border-color: #0077b6;
  box-shadow: 0 0 8px rgba(0, 119, 182, 0.4);
}

.contact-form button {
  padding: 12px;
  background-color: #0077b6;
  color: white;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  font-size: 16px;
  transition: background 0.3s;
}

.contact-form button:hover {
  background-color: #005f86;
}

/* Footer */
.footer {
  background-color: #222;
  color: #fff;
  padding: 40px 20px 20px;
}

.footer-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  gap: 30px;
  max-width: 1100px;
  margin: auto;
}

.footer-left h3 {
  font-size: 24px;
  margin-bottom: 10px;
}

.footer-left p {
  font-size: 14px;
  color: #ccc;
}

.footer-right h4 {
  font-size: 18px;
  margin-bottom: 10px;
}

.social-icons a img {
  width: 24px;
  margin-right: 10px;
  vertical-align: middle;
  transition: transform 0.3s ease;
}

.social-icons a:hover img {
  transform: scale(1.2) rotate(5deg);
}

.footer-bottom {
  text-align: center;
  margin-top: 30px;
  font-size: 14px;
  color: #888;
}

/* Animations */
@keyframes fadeUp {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

/* Responsive */
@media (max-width: 768px) {
  nav {
    flex-direction: column;
    align-items: flex-start;
  }

  nav ul {
    flex-direction: column;
    gap: 10px;
    margin-top: 10px;
  }

  .home-container h1 {
    font-size: 32px;
  }

  .about-container h2,
  .services-container h2,
  .contact-container h2 {
    font-size: 28px;
  }

  .services-grid,
  .contact-grid {
    grid-template-columns: 1fr;
  }

  .contact-intro {
    font-size: 16px;
  }
}
    </style>
    
</head>




<body>
<%@ page session="true" %>
<%
  String user = (String) session.getAttribute("username");
  if (user == null) {
    response.sendRedirect("login.jsp");
    return;
  }
%>




    <nav>
        <div class="logo">Finance Trust Solution</div>
        <ul>
            <li>
                <a href="#">Home</a>
            </li>
            <li>
                <a href="#">About</a>
            </li>

            <li>
                <a href="#">Service</a>
            </li>
            <li>
                <a href="#">Contact</a>
            </li>
            <li>
            <a href="sample data.jsp">Loan Repay</a>
            </li>
            <li>
                <a href="login.jsp">Login</a>
            </li>
        </ul>
    </nav>

    <div class="home-container">
        <h1>Welcome To Our Website</h1>
        <p>We provide reliable services to meet your needs.Explore more below</p>
        <button ><a href="loanapplicatin.jsp">Get started</a></button>
    </div>

    <!-- About Us Section -->
<section class="about-section">
  <div class="about-container">
    <h2>About Us</h2>
    <p>
      At <strong>FinTrust Solutions</strong>, we are committed to empowering individuals and businesses with smart financial services. 
      With a focus on transparency, trust, and technology, we offer tailored solutions in loans, investments, and wealth management.
    </p>
    <p>
      Our team of experienced professionals ensures secure, scalable, and customer-centric strategies 
      to help our clients achieve financial success. Whether you're growing your business or planning your future, 
      FinTrust is with you every step of the way.
    </p>
  </div>
</section>


<!-- Services Section -->
<section class="services-section" id="#service">
  <div class="services-container">
    <h2>Our Services</
    <div class="services-grid">
      
      <div class="service-card">
        <h3>Personal Loans</h3>
        <p>Flexible and quick personal loan solutions to meet your needs with low interest rates and easy EMIs.</p>
      </div>
      <div class="service-card">
        <h3>Home Loans</h3>
        <p>Make your dream home a reality with our affordable home loan plans and expert guidance at every step.</p>
      </div>

      <div class="service-card">
        <h3>Business Loans</h3>
        <p>Power up your enterprise with customized loan options designed for startups, SMEs, and large businesses.</p>
      </div>

      <div class="service-card">
        <h3>Investment Planning</h3>
        <p>Smart investment strategies tailored to your goals – mutual funds, SIPs, and more.</p>
      </div>

      <div class="service-card">
        <h3>Insurance Services</h3>
        <p>Protect your future with our trusted life, health, and general insurance options.</p>
      </div>

      <div class="service-card">
        <h3>Wealth Management</h3>
        <p>End-to-end portfolio management for high-net-worth individuals and growing businesses.</p>
      </div>

      <div class="service-card animate-on-scroll">
  <h3>Credit Score Advisory</h3>
  <p>We help you monitor and improve your credit score for better loan eligibility and financial planning.</p>
</div>

<div class="service-card animate-on-scroll">
  <h3>Tax Planning</h3>
  <p>Expert strategies to save your taxes legally and maximize your income under government guidelines.</p>
</div>

    </div>
  </div>
</section>

<!-- Contact Section -->
<section class="contact-section" id="#contact">
  <div class="contact-container">
    <h2>Contact Us</h2>
    <p class="contact-intro">We’d love to hear from you. Reach out to us for inquiries, support, or financial guidance.</p>

    <div class="contact-grid">
      <!-- Contact Info -->
      <div class="contact-info">
        <h3>Get in Touch</h3>
        <p><strong> Phone:</strong> +91 73396 78606</p>
        <p><strong> Email:</strong> support@fintrust.com</p>
        <p><strong> Address:</strong> 3/154, west street, J pudhukkottai, chinnalapatti, Dindigul</p>
      </div>

      <!-- Contact Form -->
        <form class="contact-form" action="ContactServlet" method="post">
        <h2>Contact Us</h2>
        <input type="text" name="name" placeholder="Your Name" required>
        <input type="email" name="email" placeholder="Your Email" required>
        <textarea name="message" rows="5" placeholder="Your Message" required></textarea>
        <button type="submit">Send Message</button>
    </div>
  </div>
</section>

<!-- Footer -->
<footer class="footer">
  <div class="footer-container">
    <div class="footer-left">
      <h3>Finance Trust Solutions</h3>
      <p>Trusted partner for your financial growth. Secure. Scalable. Smart.</p>
    </div>

    <div class="footer-right">
      <h4>Follow Us</h4>
      <div class="social-icons">
        <a href="#"><img src="img/facebook.png" alt="Facebook" /></a>
        <a href="#"><img src="img/twitter.jpg" alt="Twitter" /></a>
        <a href="#"><img src="img/linkedin.png" alt="LinkedIn" /></a>
      </div>
    </div>
  </div>

  <div class="footer-bottom">
    <p>&copy; 2025 FinTrust Solutions. All rights reserved.</p>
  </div>
</footer>


    
<script>
  function onScrollAnimate() {
    const elements = document.querySelectorAll('.animate-on-scroll');

    const windowHeight = window.innerHeight;
    
    elements.forEach(el => {
      const elementTop = el.getBoundingClientRect().top;

      // Trigger animation when element is 100px inside viewport
      if (elementTop < windowHeight - 100) {
        el.classList.add('visible');
      } else {
        el.classList.remove('visible');
      }
    });
  }

  window.addEventListener('scroll', onScrollAnimate);
  window.addEventListener('load', onScrollAnimate);
</script>
</body>
</html>