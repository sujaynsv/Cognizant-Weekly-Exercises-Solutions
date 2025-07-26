import React, { useState } from 'react';

const CalculateScore = ({ Name, School, total, goal }) => {
  const percentToDecimal = (decimal) => {
    return (decimal / 100) * 100 + "%";
  };

  const calcScore = (total, goal) => {
    return percentToDecimal(total / goal);
  };

  return (
    <div className="max-w-md mx-auto mt-8 p-6 bg-white rounded-lg shadow-lg border">
      <h1 className="text-2xl font-bold text-center mb-6 text-gray-800">
        Student Details
      </h1>
      
      <div className="space-y-4">
        <div>
          <span className="font-semibold text-gray-700">Name: </span>
          <span className="text-gray-900">{Name}</span>
        </div>
        
        <div>
          <span className="font-semibold text-gray-700">Name: </span>
          <span className="text-gray-900">{Name}</span>
        </div>
        
        <div className="bg-gray-50 p-4 rounded">
          <div className="font-semibold text-gray-700 mb-2">School:</div>
          <div className="ml-4">
            <span className="font-medium">School: </span>
            <span>{School}</span>
          </div>
        </div>
        
        <div className="bg-gray-50 p-4 rounded">
          <div className="font-semibold text-gray-700 mb-2">Total:</div>
          <div className="ml-4">
            <span className="font-medium">Total: </span>
            <span>{total}</span>
          </div>
          <div className="ml-4 mt-2">
            <span className="font-medium">Marks: </span>
            <span>{total}</span>
          </div>
        </div>
        
        <div className="bg-blue-50 p-4 rounded border-l-4 border-blue-500">
          <div className="font-semibold text-blue-700">Score:</div>
          <div className="text-lg font-bold text-blue-900 mt-1">
            {calcScore(total, goal)}
          </div>
        </div>
      </div>
    </div>
  );
};

export default CalculateScore;