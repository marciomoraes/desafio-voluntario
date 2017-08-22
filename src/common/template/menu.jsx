/* Componente Menu */
import React from 'react';

import MenuItem from './menuItem';
import MenuTree from './menuTree';

// Componente funcional
export default props => (
  <ul className='sidebar-menu'>
    <MenuItem path='#' label='Painel' icon='dashboard' />
    <MenuItem path='#calendar' label='Agenda' icon='calendar' />
    <MenuItem path='#diary' label='Diário de Classe' icon='paperclip' />
    <MenuItem path='#students' label='Alunos' icon='users' />
  </ul>
)
