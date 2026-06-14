import logo from './logo.svg';
import './App.css';
import SignupPage from './pages/SignupPage';
import LoginPage from './pages/LoginPage';
import Dashboard from './pages/Dashboard';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { AuthProvider } from "./context/AuthContext"; // ADD THIS
import ProtectedRoute from "./components/ProtectedRoute"; // ADD THIS
import SendMoney from "./pages/SendMoney";
import AddFunds from "./pages/AddFunds";
import Rewards from "./pages/Rewards";
import TransactionPage from "./pages/TransactionPage";
import Layout from "./components/Layout"; 
import HomePage from "./pages/HomePage"
import MyProfile from "./pages/MyProfile";
function App() {

  console.log("1 Layout:", Layout);
  console.log("2 ProtectedRoute:", ProtectedRoute);
  console.log("3 SendMoney:", SendMoney);
  console.log("4 AddFunds:", AddFunds);
  console.log("5 Rewards:", Rewards);
  console.log("6 TransactionPage:", TransactionPage);
  console.log("7 HomePage:", HomePage);
  console.log("8 MyProfile:", MyProfile);
  console.log("9 Dashboard:", Dashboard);
  console.log("10 SignupPage:", SignupPage);
  console.log("11 LoginPage:", LoginPage);
  return (
    <AuthProvider>
      <Router>
        <Routes>

          <Route path="/signup" element={<SignupPage />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/" element={<HomePage />} />

          <Route
            path="/home"
            element={
              <ProtectedRoute>
                <Dashboard />
              </ProtectedRoute>
            }
          />

          <Route
            path="/send-money"
            element={
              <ProtectedRoute>
                <Layout showBackButton={true} showQuickActions={true}>
                  <SendMoney />
                </Layout>
              </ProtectedRoute>
            }
          />

          <Route
            path="/profile"
            element={
              <ProtectedRoute>
                <Layout
                  title="My Profile"
                  subtitle="Manage your account settings"
                  showBackButton={true}
                  showQuickActions={true}
                >
                  <MyProfile />
                </Layout>
              </ProtectedRoute>
            }
          />

          <Route
            path="/add-funds"
            element={
              <ProtectedRoute>
                <Layout showBackButton={true} showQuickActions={true}>
                  <AddFunds />
                </Layout>
              </ProtectedRoute>
            }
          />

          <Route
            path="/rewards"
            element={
              <ProtectedRoute>
                <Layout showBackButton={true} showQuickActions={true}>
                  <Rewards />
                </Layout>
              </ProtectedRoute>
            }
          />

          <Route
            path="/transactions"
            element={
              <ProtectedRoute>
                <Layout showBackButton={true} showQuickActions={true}>
                  <TransactionPage />
                </Layout>
              </ProtectedRoute>
            }
          />

        </Routes>
      </Router>
    </AuthProvider>
  );
}
export default App;
