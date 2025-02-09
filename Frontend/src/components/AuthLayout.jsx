import React from 'react';

const AuthLayout = ({ children }) => {
  return (
    <div className="min-h-screen flex  justify-center bg-gray-100 py-24 px-4 sm:px-6 lg:px-8">
      <div className="max-w-md w-full space-y-8">
        {children}
      </div>
    </div>
  );
};

export default AuthLayout;
