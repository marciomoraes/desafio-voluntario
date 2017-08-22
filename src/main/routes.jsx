/* Rotas */
import React from 'react';
import { Router, Route, Redirect, hashHistory } from 'react-router';

import Dashboard from '../dashboard/dashboard';
import Calendar from '../calendar/calendar';
import Diary from '../diary/diary';
import Students from '../students/students';

export default props => (
  <Router history={hashHistory}>
    <Route path='/' component={Dashboard} />
    <Route path='/calendar' component={Calendar} />
    <Route path='/diary' component={Diary} />
    <Route path='/students' component={Students} />
    <Redirect from='*' to='/' />
  </Router>
);
