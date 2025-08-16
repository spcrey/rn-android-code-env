import {
  Text,
  View,
} from 'react-native';

const ReactFragmentComponent = (pros: {data: string}) => {
    return (<View>
        <Text>
            ReactFragmentComponent: Data: {pros.data}
        </Text>
    </View>)
}

export default ReactFragmentComponent