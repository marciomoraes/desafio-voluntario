/* Componente Menu Tree */
import React from 'react';

// componente funcional
export default props => (
  <li className='treeview'>
    <a href>
      <i className={`fa fa-${props.icon}`}></i> {props.label}
      <i className='fa fa-angle-left pull-right'></i>
    </a>
    <ul className='treeview-menu'>
      {props.children}
    </ul>
  </li>
)
