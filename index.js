/**
 * @format
 */

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './app.json';
import ReactActivityComponentView from './ReactActivityComponent'
import ReactFragmentComponentView from './ReactFragmentComponent'

AppRegistry.registerComponent(appName, () => App);
AppRegistry.registerComponent('ReactActivityComponent', () => ReactActivityComponentView);
AppRegistry.registerComponent('ReactFragmentComponent', () => ReactFragmentComponentView);
