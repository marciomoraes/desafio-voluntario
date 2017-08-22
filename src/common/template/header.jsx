/* Componente Header */
import React from 'react';

// Componente funcional
export default props => (
  <header className='main-header'>
    <a href='/#/' className='logo'>
      <span className='logo-mini'></span>
      <span className='logo-lg'>Desafio</span>
    </a>
    <nav className='navbar navbar-static-top'>
      <a href className='sidebar-toggle' data-toggle='offcanvas'></a>
    </nav>
  </header>
)
